package com.soup.memo.netty.socket;

import lombok.extern.slf4j.Slf4j;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * <p>
 * Description: socket 服务端
 * </p>
 *
 * @author zhaoyi
 * @date 2019/1/3 00:01
 */
@Slf4j
public class SocketServer {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                            .childHandler(new SocketServerInitializer());

            ChannelFuture future = serverBootstrap.bind(8899).sync();
            long end = System.currentTimeMillis();
            log.info("socket server started in {} seconds", (end - start) / 1000);
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
