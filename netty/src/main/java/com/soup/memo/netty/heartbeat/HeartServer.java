package com.soup.memo.netty.heartbeat;

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
 * @date 2019-01-05 22:45
 * @since 1.0
 */
@Slf4j
public class HeartServer {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                            .handler(new LoggingHandler(LogLevel.INFO))
                            .childHandler(new HeartServerInitializer());

            ChannelFuture future = serverBootstrap.bind(8899).sync();
            long end = System.currentTimeMillis();
            log.info("chart server started in {} seconds", (end - start) / 1000);

            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
