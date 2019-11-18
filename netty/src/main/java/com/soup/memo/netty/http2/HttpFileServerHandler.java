package com.soup.memo.netty.http2;

import cn.hutool.http.HttpStatus;
import com.sun.activation.registries.MimeTypeFile;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressiveFuture;
import io.netty.channel.ChannelProgressiveFutureListener;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.stream.ChunkedFile;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import javax.activation.MimetypesFileTypeMap;
import java.awt.datatransfer.MimeTypeParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.util.regex.Pattern;

/**
 * HTTP文件服务器的业务处理逻辑器
 *
 * @author zhaoyi
 */
@Slf4j
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final String url;

    public HttpFileServerHandler(String url) {
        this.url = url;
    }

    /**
     * messageReceived
     *
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        if (request.decoderResult().isFailure()) {
            sendError(ctx, HttpResponseStatus.BAD_REQUEST);
            return;
        }
        if (!request.method().equals(HttpMethod.GET)) {
            return;
        }

        final String uri = request.uri();
        final String path = new URI(uri).getPath();
        if (null == path) {
            return;
        }

        File file = new File(path);
        if (file.isHidden() || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {

        }
        if (!file.isFile()) {

        }

        RandomAccessFile randomAccessFile = null;
        try {
            // 以只读方式打开文件
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException e) {
            return;
        }

        long fileLength = randomAccessFile.length();
        HttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, fileLength);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, file);

        response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        ctx.write(response);

        ChannelFuture sendFileFuture = ctx.write(new ChunkedFile(randomAccessFile, 0, fileLength, 8192), ctx.newProgressivePromise());
        sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
            @Override
            public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) throws Exception {
                if (total < 0) {
                    log.info("Transfer progress: {}", progress);
                } else {
                    log.info("Transfer progress: {}/{}", progress, total);
                }
            }

            @Override
            public void operationComplete(ChannelProgressiveFuture future) throws Exception {
                log.info("Transfer completed.");
            }
        });

        ChannelFuture lastContentFuture = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("", cause);
        // 发生异常，关闭链路
        ctx.close();
    }

    private static final Pattern INSTANCE_URI = Pattern.compile(".*[<>&\"].*");

    private String sanitizeUri(String uri) {


        return System.getProperty("user.dir") + File.separator + uri;
    }



    /**
     * 重定向
     *
     * @param ctx ChannelHandlerContext
     * @param redirectUri 重定向的uri
     */
    private static void sendRedirect(ChannelHandlerContext ctx, String redirectUri) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FOUND);
        response.headers().set(HttpHeaderNames.LOCATION, redirectUri);
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * 发生错误，返回错误响应
     *
     * @param ctx ChannelHandlerContext
     * @param responseStatus 响应错误码
     */
    private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus responseStatus) {
        String failureMsg = "Failure: " + responseStatus.toString() + "\r\n";
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, responseStatus, Unpooled.copiedBuffer(failureMsg, CharsetUtil.UTF_8));
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private static void setContentTypeHeader(HttpResponse response, File file) {
        MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
        response.headers().set("", mimetypesFileTypeMap.getContentType(file));
    }
}
