package com.soup.memo.thread.communication;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 使用CountDownLatch工具类实现线程间的通信
 *
 * @author zhaoyi
 */
@Slf4j
public class CountDownLatchTest {

    public static void main(String[] args) throws Exception {
        countDownLatch();
    }

    private static void countDownLatch() throws Exception {
        int threadSize = 3;
        Stopwatch stopwatch = Stopwatch.createStarted();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);

        for (int i = 0; i < threadSize; i++) {
            final int number = i;
            new Thread(() -> {
                log.info("thread-{} running.", number);
                try {
                    Thread.sleep(2000);
                    countDownLatch.countDown();
                    log.info("thread-{} end.", number);
                } catch (Exception e) {
                    log.error("", e);
                }
            }, "thread-" + i).start();
        }

        countDownLatch.await();
        log.info("time comsume: {}ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

}
