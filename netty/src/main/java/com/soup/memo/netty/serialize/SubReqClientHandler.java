package com.soup.memo.netty.serialize;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-17 23:17
 * @since 1.0
 */
@Slf4j
public class SubReqClientHandler extends SimpleChannelInboundHandler<SubscribeResp> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SubscribeResp msg) throws Exception {
        log.info("after send request, server response info: {}", msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // buid requests, send to server
        for (int i = 0; i < 10; i++) {
            ctx.channel().writeAndFlush(buidRequest(i + ""));
        }
    }

    private SubscribeReq buidRequest(String requestId) {
        SubscribeReq request = new SubscribeReq();
        request.setSubReqId(requestId);
        request.setAddress("江宁区东山街道" + requestId + "号");
        request.setPhoneNumber("180xxxxxxxxx");
        request.setUserName("test");
        request.setProductName("Netty Book");

        return request;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("", cause);
        // 发生异常，关闭链路
        ctx.close();
    }
}
