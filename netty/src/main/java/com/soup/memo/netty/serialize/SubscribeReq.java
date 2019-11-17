package com.soup.memo.netty.serialize;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *  客户端请求服务端的请求对象
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-17 22:37
 * @since 1.0
 */
@Data
public class SubscribeReq implements Serializable {

    private static final long serialVersionUID = -768938381697470030L;

    private String subReqId;

    private String userName;

    private String productName;

    private String phoneNumber;

    private String address;
}
