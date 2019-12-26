package com.soup.memo.thread.communication;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

/**
 * 使用CyclicBarrier进行线程间的通信
 *
 * @author zhaoyi
 */
@Slf4j
public class CyclicBarrierTest {

    public static void main(String[] args) {
        cyclicBarrier();
    }

    private static void cyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread(() -> {
            log.info("thread-1 start");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                log.error("", e);
            }
            log.info("thread-1 end do somthing");
        }, "thread-1").start();

        new Thread(() -> {
            log.info("thread-2 start");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                log.error("", e);
            }
            log.info("thread-2 end do somthing");
        }, "thread-2").start();

        new Thread(() -> {
            log.info("thread-1 start");
            try {
                Thread.sleep(5000);
                cyclicBarrier.await();
            } catch (Exception e) {
                log.error("", e);
            }
            log.info("thread-3 end do somthing");
        }, "thread-3").start();

        log.info("all thread end");
    }
}
