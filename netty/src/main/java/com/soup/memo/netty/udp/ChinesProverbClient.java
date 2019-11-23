package com.soup.memo.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

/**
 * <p>
 *  Netty UDP客户端示例：谚语客户端
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-23 16:20
 * @since 1.0
 */
@Slf4j
public class ChinesProverbClient {

    public static void main(String[] args) throws Exception {
        new ChinesProverbClient().run(8080);
    }

    public void run(int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChineseProverbClientHandler());
            Channel ch = bootstrap.bind(port).sync().channel();

            // 向网段内的所有机器广播UDP消息
            ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("谚语字段查询？", CharsetUtil.UTF_8), new InetSocketAddress("255.255.255.255", port))).sync();
            if (!ch.closeFuture().await(15000)) {
                log.error("向服务端查询时间超时！");
            }
        } finally {
            group.shutdownGracefully();
        }
    }
}
