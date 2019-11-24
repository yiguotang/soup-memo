package com.soup.memo.netty.privateprotocol;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * Netty 消息头
 *
 * @author zhaoyi
 */
@Data
public final class Header {

    private int crcCode = 0xabef0101;

    /**
     * 消息长度
     */
    private int length;

    /**
     * 会话ID
     */
    private long sessionID;

    /**
     * 消息类型
     */
    private byte type;

    /**
     * 消息优先级
     */
    private byte priority;

    /**
     * 附件
     */
    private Map<String, Object> attachment = Maps.newHashMap();
}
