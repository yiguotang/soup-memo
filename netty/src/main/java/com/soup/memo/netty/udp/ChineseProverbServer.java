package com.soup.memo.netty.udp;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  Netty UDP示例：谚语服务端
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-23 16:02
 * @since 1.0
 */
@Slf4j
public class ChineseProverbServer {

    public static void main(String[] args) throws Exception {
        new ChineseProverbServer().run(8080);
    }

    public void run(int port) throws Exception {
        TimeInterval interval = DateUtil.timer();

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChineseProverbServerHandler());
            log.info("服务启动，花费时间：{}ms", interval.intervalRestart());
            bootstrap.bind(port).sync().channel().closeFuture().await();
        } finally {
            group.shutdownGracefully();
        }
    }
}
