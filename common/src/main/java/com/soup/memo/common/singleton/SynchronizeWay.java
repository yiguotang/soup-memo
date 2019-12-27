package com.soup.memo.common.singleton;

/**
 * 使用 synchronized 方式实现
 *
 * @author zhaoyi
 */
public class SynchronizeWay {

    private static SynchronizeWay instance;

    private SynchronizeWay() {}

    /**
     * 整个方法的 synchronized 会影响性能
     * @return 单例对象实例
     */
    public static synchronized SynchronizeWay getInstance() {
        if (null == instance) {
            instance = new SynchronizeWay();
        }

        return instance;
    }
}
