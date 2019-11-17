package com.soup.memo.netty.serialize;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  订购服务处理类
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-17 22:57
 * @since 1.0
 */
@Slf4j
public class SubReqServerHandler extends SimpleChannelInboundHandler<SubscribeReq> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SubscribeReq msg) throws Exception {
        if ("test".equals(msg.getUserName())) {
            // 打印符合服务端需要处理的数据
            // 打印客户端请求信息：
            log.info("Service accept client subscribe req: {}", msg);

            // 服务端响应：构建响应消息体写回
            SubscribeResp response = buidResponse(msg.getSubReqId());
            ctx.channel().writeAndFlush(response);
        }
    }

    private SubscribeResp buidResponse(String subReqId) {
        SubscribeResp responseInfo = new SubscribeResp();
        responseInfo.setSubReqId(subReqId);
        responseInfo.setRespCode(0);
        responseInfo.setDesc("Netty book order successed, 3 days later, sent to the designated address");

        return responseInfo;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("", cause);
        // 发生异常，关闭链路
        ctx.close();
    }
}
