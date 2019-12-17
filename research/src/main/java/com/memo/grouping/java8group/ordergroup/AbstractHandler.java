package com.memo.grouping.java8group.ordergroup;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Stream;

/**
 * 订单拆单分组抽象类
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public abstract class AbstractHandler<T> {

    /**
     * handler的类型：拆单、设置、分组
     */
    private HandlerType handlerType;

    /**
     * 下一个拆单/分组的Handler
     */
    private AbstractHandler<T> nextHandler;

    public AbstractHandler(HandlerType handlerType) {
        this.handlerType = handlerType;
    }

    /**
     * 设置下一个处理者
     */
    public AbstractHandler<T> setNext(AbstractHandler<T> nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public final Stream<T> handler(Stream<T> stream) {

        Stream<T> handlerStream = stream;
        // 处理逻辑，分别处理
        switch (handlerType) {
            case split:
                // 拆单
                handlerStream = split(stream);
                break;
            case setup:
                // 分组配置
                handlerStream = setupGroupConfig(stream);
                break;
            case sort:
                // 排序
                handlerStream = sort(stream);
                break;
            default:
                break;
        }

        // 如果设置了下一个处理者，进行执行
        if (null != nextHandler) {
            handlerStream = nextHandler.handler(handlerStream);
        }

        return handlerStream;
    }

    /**
     * 拆单
     *
     * @return 带拆单行为的stream
     */
    protected Stream<T> split(Stream<T> stream) {
        return null;
    }

    /**
     * 设置分组配置
     *
     * @return 带设置行为的stream
     */
    protected Stream<T> setupGroupConfig(Stream<T> stream) {
        return null;
    }

    /**
     * 排序
     *
     * @return 带排序的stream
     */
    protected Stream<T> sort(Stream<T> stream) {
        return null;
    }

    /**
     * 分组
     *
     * @param obj 分组的入参
     * @return 分组后的结果：分组对象为 Map<ScprsScpOrderHead, List<ScprsScpOrderItem>>
     */
    protected Object group(Object obj) {
        return null;
    }

    private boolean isStream(Object obj) {
        return obj instanceof Stream;
    }

    private boolean isList(Object obj) {
        return obj instanceof List;
    }
}
