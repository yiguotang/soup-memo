package com.soup.memo.netty.http;

import java.net.URI;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * <p>
 * Description: 自定义处理器，对于Inbound
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-02 17:32
 */
@Slf4j
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * messageReceived
     *
     * @param ctx ChannelHandlerContext
     * @param msg HttpObject
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        log.info("{}", msg.getClass());
        log.info("{}", ctx.channel().remoteAddress());

        Thread.sleep(8000);

        if (msg instanceof HttpRequest) {

            HttpRequest request = (HttpRequest) msg;
            log.info("request method name: {}", request.method().name());

            URI uri = new URI(request.uri());
            if (StringUtils.equals("/favicon.ico", uri.getPath())) {
                log.info("request /favicon reject ...");
                return;
            }

            log.info("request uri: {}", request.method().name());

            // 定义向client返回的内容：Hello World！
            ByteBuf content = Unpooled.copiedBuffer("Hello World!", CharsetUtil.UTF_8);
            // 定义返回的response：http version, status, content
            FullHttpResponse response =
                            new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            // 定义返回头
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            // 返回client
            ctx.writeAndFlush(response);
            ctx.channel().close();
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("channel active ...");
        super.channelActive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channel registered ...");
        super.channelRegistered(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("handler added ...");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("channel inactive ...");
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channel unregistered ... ");
        super.channelUnregistered(ctx);
    }
}
