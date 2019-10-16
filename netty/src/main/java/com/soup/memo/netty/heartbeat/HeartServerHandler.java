package com.soup.memo.netty.heartbeat;

import lombok.extern.slf4j.Slf4j;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-05 22:51
 * @since 1.0
 */
@Slf4j
public class HeartServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "read free";
                    break;
                case WRITER_IDLE:
                    eventType = "wirte free";
                    break;
                case ALL_IDLE:
                    eventType = "read & wirte free";
                    break;
                default:
                    break;
            }

            log.info("{} timeout event: {}", ctx.channel().remoteAddress(), eventType);
            ctx.channel().close();
        }
    }
}
