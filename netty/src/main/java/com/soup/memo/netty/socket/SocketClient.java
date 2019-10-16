package com.soup.memo.netty.socket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description: socket client
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-03 17:43
 */
@Slf4j
public class SocketClient {

    public static void main(String[] args) throws Exception {
        EventLoopGroup connectGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(connectGroup).channel(NioSocketChannel.class).handler(new SocketClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            connectGroup.shutdownGracefully();
        }
    }
}
