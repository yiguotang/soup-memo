package com.soup.memo.netty.websocket;

import java.net.InetSocketAddress;

import lombok.extern.slf4j.Slf4j;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-05 23:24
 * @since 1.0
 */
@Slf4j
public class WebsocketServer {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                            .handler(new LoggingHandler(LogLevel.INFO))
                            .childHandler(new WebsocketServerChannelInitializer());

            ChannelFuture future = serverBootstrap.bind(new InetSocketAddress(899)).sync();
            long end = System.currentTimeMillis();
            log.info("websocket server started in {} seconds", (end - start) / 1000);

            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
