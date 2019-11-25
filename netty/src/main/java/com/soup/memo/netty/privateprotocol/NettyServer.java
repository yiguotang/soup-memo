package com.soup.memo.netty.privateprotocol;

import cn.hutool.core.date.TimeInterval;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  Netty Server
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-25 23:17
 * @since 1.0
 */
@Slf4j
public class NettyServer {

    public static void main(String[] args) throws Exception {

        TimeInterval interval = new TimeInterval();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 4, 4, -8, 0))
                                    .addLast(new NettyMessageEncoder())
                                    .addLast(new LoginAuthRespHandler());
                        }
                    });
            ChannelFuture cf = bootstrap.bind(9080).sync();
            log.info("server started in {}ms at port {}", interval.intervalRestart(), 9080);
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
