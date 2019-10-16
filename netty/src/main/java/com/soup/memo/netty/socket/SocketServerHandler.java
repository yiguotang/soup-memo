package com.soup.memo.netty.socket;

import java.util.UUID;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description: 自己的handler
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-03 17:32
 */
@Slf4j
public class SocketServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 远程client地址和消息内容
        log.info(ctx.channel().remoteAddress() + ", " + msg);

        // 客户端返回内容给client
        ctx.channel().writeAndFlush("msg from server: " + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 发生异常，关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
