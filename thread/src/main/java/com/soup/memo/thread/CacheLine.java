package com.soup.memo.thread;

/**
 * <p>
 *  缓存行 cache line 为 64 个字节
 *  cpu的缓存通信是通过 cache line 为最小单位
 * </p>
 *
 * @author zhaoyi
 * @date 2020-03-05 22:12
 * @since 1.0
 */
public class CacheLine {

    private static class T {
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
