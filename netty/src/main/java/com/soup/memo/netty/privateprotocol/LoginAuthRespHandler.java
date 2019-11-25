package com.soup.memo.netty.privateprotocol;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     握手和安全认证响应handler
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-25 22:57
 * @since 1.0
 */
@Slf4j
public class LoginAuthRespHandler extends ChannelHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        NettyMessage message = (NettyMessage) msg;
        // 如果是握手应答消息，需要判断是否认证成功
        if (null != message.getHeader() && (byte) 1 == message.getHeader().getType()) {
            log.info("Login is OK");
            String body = (String) message.getBody();
            log.info("Received message body from client is {}", body);
        }
        ctx.fireChannelRead(buildLoginResponse((byte) 3));
    }

    public void channelReadCompleted(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("exception occured!", cause);
        ctx.close();
    }

    private NettyMessage buildLoginResponse(byte result) {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType((byte) 2);
        message.setHeader(header);
        message.setBody(result);
        return message;
    }
}
