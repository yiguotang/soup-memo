package com.soup.memo.netty.privateprotocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 *  Netty client
 *     https://blog.csdn.net/ITer_ZC/article/details/39317311
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-25 23:04
 * @since 1.0
 */
@Slf4j
public class NettyClient {

    public static void main(String[] args) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // -8表示lengthAdjustment，让解码器从0开始截取字节，并且包含消息头
                            ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 4, 4, -8, 0))
                                    .addLast(new NettyMessageEncoder())
                                    .addLast(new LoginAuthReqHandler());
                        }
                    });

            // 连接端口和地址
            String host = "127.0.0.1";
            int port = 9080;
            ChannelFuture cf = bootstrap.connect(host, port).sync();
            log.info("client conneted at prot {} address {}", port, host);

            cf.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
