package com.soup.memo.netty.privateprotocol;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  握手和安全认证请求handler
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-25 14:09
 * @since 1.0
 */
@Slf4j
public class LoginAuthReqHandler extends ChannelHandlerAdapter {

    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(buildLoginReq());
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        NettyMessage message = (NettyMessage) msg;
        // 如果是握手应答消息，需要判断是否认证成功
        if (null != message.getHeader() && (byte) 2 == message.getHeader().getType()) {
            log.info("Received from server response");
        }
        ctx.fireChannelRead(buildLoginReq());
    }

    public void channelReadCompleted(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("exception occured!", cause);
        ctx.close();
    }

    private NettyMessage buildLoginReq() {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType((byte) 1);
        message.setHeader(header);
        message.setBody("It is request");

        return message;
    }
}
