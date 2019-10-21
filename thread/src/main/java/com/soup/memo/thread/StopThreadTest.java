package com.soup.memo.thread;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Description: Synchronized 影响可见性的问题
 * JVM对于现代的机器做了最大程度的优化，也就是说，最大程度的保障了线程和主存之间的及时的同步，
 * 也就是相当于虚拟机尽可能的帮我们加了个volatile，
 * 但是，当CPU被一直占用的时候，同步就会出现不及时，也就出现了后台线程一直不结束的情况
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-18 14:16
 */
@Slf4j
public class StopThreadTest {

    private static boolean stop = false;

    public static void main(String[] args) throws Exception {
//        useSynchronized();
//        useSleep();
        use();
    }

    private static void useSynchronized() throws Exception {
        new Thread(() -> {
            Object lock = new Object();
            int i = 0;
            while (!stop) {
                ++i;
                System.out.println(i);

                /*synchronized (lock) {

                }*/
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }

    private static void useSleep() throws Exception {
        new Thread(() -> {
            long start = System.nanoTime();
            int i = 0;
            while (!stop) {
                ++i;
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                }
            }
            long end = System.nanoTime();
            Duration d = Duration.ofNanos(end - start);
            System.out.println(d.toMillis() + "ms");
        }).start();

        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }

    private static void use() throws Exception {
        new Thread(() -> {
            long start = System.nanoTime();
            int i = 0;
            while (!stop) {
                ++i;

                Object[] arr = new Object[1000000];
            }
            long end = System.nanoTime();
            Duration d = Duration.ofNanos(end - start);
            System.out.println(d.toMillis() + "ms");
        }).start();

        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }
}
