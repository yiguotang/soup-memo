package com.soup.memo.netty.privateprotocol;

import lombok.Data;

/**
 * Netty 消息
 *
 * @author zhaoyi
 */
@Data
public final class NettyMessage {

    /**
     * 消息头
     */
    private Header header;

    /**
     * 消息体
     */
    private Object body;
}
