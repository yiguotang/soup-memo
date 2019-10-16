package com.soup.memo.netty.multiconnect;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-04 12:49
 */
@Slf4j
public class ChartClient {

    public static void main(String[] args) throws Exception {
        EventLoopGroup connectGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(connectGroup).channel(NioSocketChannel.class).handler(new ChartClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (;;) {
                channel.writeAndFlush(br.readLine() + "\r\n");
            }
        } finally {
            connectGroup.shutdownGracefully();
        }
    }
}
