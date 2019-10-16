package com.soup.memo.netty.multiconnect;

import lombok.extern.slf4j.Slf4j;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * <p>
 * Description: 聊天室server, 一对多的连接方式
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-04 10:13
 */
@Slf4j
public class ChartServer {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                            .childHandler(new ChartServerInitializer());

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
