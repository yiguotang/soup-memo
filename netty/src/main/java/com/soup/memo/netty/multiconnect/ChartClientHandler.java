package com.soup.memo.netty.multiconnect;

import lombok.extern.slf4j.Slf4j;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-03 17:54
 */
@Slf4j
public class ChartClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("{}", msg);
    }
}
