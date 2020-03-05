package com.soup.memo.thread;

/**
 * <p>
 *  缓存行填充，juc的类：LinkedTransferQueue
 *
 *  diruptor环形队列框架，使用了缓存行填充的方式，来增加执行速度
 *
 *  缓存行 cache line 为 64 个字节
 *  cpu的缓存通信是通过 cache line 为最小单位
 * </p>
 *
 * @author zhaoyi
 * @date 2020-03-05 22:12
 * @since 1.0
 */
public class CacheLineV2 {

    // 缓存行填充
    private static class Padding {
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    // 这样
    private static class T extends Padding {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                arr[1].x = i;
            }
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start) / 1000_0000);
    }

}
