package com.soup.memo.netty.privateprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Netty 消息解码类
 *
 * @author zhaoyi
 */
public final class NettyMessageDecoder extends LengthFieldBasedFrameDecoder {

    private NettyMarshallingDecoder marshallingDecoder;

    public NettyMessageDecoder(int maxFrameLength, int lengthFileOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFileOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
        this.marshallingDecoder = MarshallingCodecFactory.buildMarshallingDecoder();
    }

    protected Object dencode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
        if (null == frame) {
            return null;
        }

        NettyMessage nettyMessage = new NettyMessage();
        Header header = new Header();
        header.setCrcCode(frame.readInt());
        header.setLength(frame.readInt());
        header.setSessionID(frame.readLong());
        header.setType(frame.readByte());
        header.setPriority(frame.readByte());

        int size = frame.readInt();
        if (size > 0) {
            Map<String, Object> attach = new HashMap<>(size);
            int keySize;
            byte[] keyArray;
            String key;
            for (int i = 0; i < size; i++) {
                keySize = frame.readInt();
                keyArray = new byte[keySize];
                in.readBytes(keyArray);
                key = new String(keyArray, StandardCharsets.UTF_8);
                attach.put(key, marshallingDecoder.decode(ctx, frame));
            }
            key = null;
            keyArray = null;
            header.setAttachment(attach);
        }

        if (frame.readableBytes() > 0) {
            nettyMessage.setBody(marshallingDecoder.decode(ctx, frame));
        }
        nettyMessage.setHeader(header);
        return nettyMessage;
    }
}
