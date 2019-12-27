package com.soup.memo.common.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 借助 volatile 关键字 双重检查锁 实现单例的方式
 *
 * @author zhaoyi
 */
@Slf4j
public class DclWay {

    private static volatile DclWay instance;

    private DclWay() {}

    public static DclWay getInstance() {
        if (null == instance) {
            synchronized (DclWay.class) {
                if (null == instance) {
                    // volatile 修饰的变量 进行单个写/读操作 具有原子性
                    // new DclWay();的三个操作 由于 volatile 添加了内存屏障，保证了顺序性
                    instance = new DclWay();
                }
            }
        }

        return instance;
    }
}
