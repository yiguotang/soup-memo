package com.soup.memo.netty.http;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description: 测试http服务器端
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-02 17:19
 */
@Slf4j
public class HttpServer {

    /**
     * server 启动
     * @param args 参数
     */
    public static void main(String[] args) throws Exception {
        TimeInterval interval = DateUtil.timer();

        // 不断从客户端接受连接，但不处理，交给后面的线程组进行处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 处理请求的的工作线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 服务端启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                            .childHandler(new HttpServerInitializer());

            // 绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            log.info("server started in {}ms", interval.intervalRestart());

            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
