package com.soup.memo.thread.threadlocal;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoyi
 * @date 2020-03-03 22:31
 * @since 1.0
 */
public class ThreadLocalTest implements Runnable {
    public static ThreadLocal<String> localString = new ThreadLocal<>();

    public ThreadLocalTest(String str) {
        localString.set(str);
    }


    @Override
    public void run() {

    }
}
