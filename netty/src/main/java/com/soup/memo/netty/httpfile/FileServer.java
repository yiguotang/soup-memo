package com.soup.memo.netty.httpfile;

import cn.hutool.core.date.TimeInterval;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * FileChannel文件服务Demo <br/>
 * 具体流程场景
 * <li>Netty 文件服务启动，绑定8080作为内部监听端口</li>
 * <li>通过Telnet作为客户端与服务端建立TCP连接</li>
 * <li>控制台输入文件的绝对路径</li>
 * <li>文件服务器接收到消息后，进行合法性判断，如果文件存在，则将文件发送客户端cmd控制台</li>
 * <li>cmd控制台打印文件名和文件内容,telnet localhost 8080, 然后输入文件的绝对路径回车</li>
 *
 * @author zhaoyi
 */
@Slf4j
public class FileServer {

    public static void main(String[] args) throws Exception {
        TimeInterval interval = new TimeInterval();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(
                                    // 将文件内容编码为字符串，这样客户的cmd窗口中就可以打印出来
                                    new StringEncoder(CharsetUtil.UTF_8),
                                    // LineBasedFrameDecoder 能够按照回车换行符对数据报进行解码
                                    new LineBasedFrameDecoder(1024),
                                    // 将数据报解码成字符串
                                    new StringDecoder(CharsetUtil.UTF_8),
                                    new FileServerHandler()
                                    );
                        }
                    });
            ChannelFuture cf = bootstrap.bind(8080).sync();
            log.info("file serer start in {}ms, listenered port: 8080", interval.intervalRestart());
            cf.channel().closeFuture().sync();
        } finally {
            // 优雅退出
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
