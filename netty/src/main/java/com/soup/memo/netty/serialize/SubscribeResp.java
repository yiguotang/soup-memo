package com.soup.memo.netty.serialize;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *  服务端返回给客户端的响应对象
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-17 22:39
 * @since 1.0
 */
@Data
public class SubscribeResp implements Serializable {

    private static final long serialVersionUID = -4729541726017138212L;

    private String subReqId;

    private int respCode;

    private String desc;
}
