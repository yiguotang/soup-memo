package com.soup.memo.netty.httpfile;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * HTTP 文件服务器
 *
 * @author zhaoyi
 */
@Slf4j
public class HttpFileServer {

    private static final String DEFAULT_URL = "/netty/";

    public static void main(String[] args) throws Exception {
        new HttpFileServer().run(8899, DEFAULT_URL);
    }

    public void run(final int port, final String url) throws Exception {

        TimeInterval interval = DateUtil.timer();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline pipeline = ch.pipeline();
                            // 添加HTTP消息解码器
                            pipeline.addLast("http-decoder", new HttpRequestDecoder());

                            // 将多个消息转换为单一的FullHttpRequest或FullHttpResponse
                            // 因为HTTP解码器在每个HTTP消息中会生成多个消息对象：HttpRequest/HttpResponse、HttpContent、LastHttpContent
                            pipeline.addLast("http-aggregator", new HttpObjectAggregator(65536));

                            // 添加HTTP响应编码器，对HTTP响应消息进行编码
                            pipeline.addLast("http-encoder", new HttpResponseEncoder());

                            // 支持异步发送大的码流，如：大的文件传输，但不占用过多的内存，防止出现java内存溢出
                            pipeline.addLast("http-chunked", new ChunkedWriteHandler());

                            // 添加业务处理逻辑器
                            pipeline.addLast("fileServerHandler", new HttpFileServerHandler(url));
                        }
                    });

            ChannelFuture cf = bootstrap.bind(port).sync();
            log.info("Http 文件目录服务器启动，网址：http://127.0.0.1:{}{}，启动时间：{}ms", port, url, interval.intervalRestart());
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
