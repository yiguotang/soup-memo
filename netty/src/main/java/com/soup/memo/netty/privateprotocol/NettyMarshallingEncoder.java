package com.soup.memo.netty.privateprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  扩展MarshallingEncoder，将protected方法编程public可以调用
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-25 13:04
 * @since 1.0
 */
@Slf4j
public class NettyMarshallingEncoder extends MarshallingEncoder {

    public NettyMarshallingEncoder(MarshallerProvider provider) {
        super(provider);
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) {
        try {
            super.encode(ctx, msg, out);
        } catch (Exception e) {
            log.error("encode msg error", e);
        }
    }
}
