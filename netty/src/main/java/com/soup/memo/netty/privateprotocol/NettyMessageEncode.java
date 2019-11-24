package com.soup.memo.netty.privateprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Netty 消息编码类
 *
 * @author zhaoyi
 */
public final class NettyMessageEncode extends MessageToMessageEncoder<NettyMessage> {

    private MarshallingCodeCFactory marshallingCodeCFactory;

    public NettyMessageEncode() {
        this.marshallingCodeCFactory = new MarshallingCodeCFactory();
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, List<Object> out) throws Exception {
        if (null == msg || null == msg.getHeader()) {
            throw new Exception("The encode message is null");
        }

        ByteBuf sendBuf = Unpooled.buffer();
        sendBuf.writeInt(msg.getHeader().getCrcCode());
        sendBuf.writeInt(msg.getHeader().getLength());
        sendBuf.writeLong(msg.getHeader().getSessionID());
        sendBuf.writeByte(msg.getHeader().getType());
        sendBuf.writeByte(msg.getHeader().getPriority());
        sendBuf.writeInt(msg.getHeader().getAttachment().size());

        String key = null;
        Object value = null;
        msg.getHeader().getAttachment().forEach((k, v) -> {
            byte[] keyArray = k.getBytes(StandardCharsets.UTF_8);
            sendBuf.writeInt(keyArray.length);
            sendBuf.writeBytes(keyArray);

            marshallingCodeCFactory.encode(v, sendBuf);
        });


    }
}
