package com.soup.memo.common;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 关于volatile关键字的相关测试
 *
 * @author zhaoyi
 */
@Slf4j
public class Volatile {

    private static volatile int val = 0;

    private static AtomicInteger val2 = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        int threadSize = 30;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);

        for (int i = 0; i < threadSize; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    // 复合操作对val的赋值，无法保证原子性
                    // val++;

                    // 同样是复合操作，无法保证原子性
                    val = val + 1;

                    val2.incrementAndGet();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        log.info("after runing, val: {}", val);
        log.info("after runing, val2: {}", val2.get());
    }
}
