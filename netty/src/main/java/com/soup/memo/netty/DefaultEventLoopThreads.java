package com.soup.memo.netty;

import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  查看NioEventLoopGroup默认构造方法，默认会赋值多少线程数量
 * </p>
 *
 * @author zhaoyi
 * @date 2019-12-26 0:06
 * @since 1.0
 */
@Slf4j
public class DefaultEventLoopThreads {

    public static void main(String[] args) {
        /**
         * {@link MultithreadEventLoopGroup} 中的static静态代码块中的初始化操作
         */
        log.info("io.netty.eventLoopThreads: {}", SystemPropertyUtil.getInt("io.netty.eventLoopThreads", -1));
        log.info("availableProcessors: {}", NettyRuntime.availableProcessors());
    }
}
