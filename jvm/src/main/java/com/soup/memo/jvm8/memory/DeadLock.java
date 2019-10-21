package com.soup.memo.jvm8.memory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author zhaoyi
 * @description 死锁示例
 * @date 2019-03-24 21:34
 **/
public class DeadLock {

    private static final Logger LOGGER = LogManager.getLogger(DeadLock.class);

    public static void main(String[] args) {

        new Thread(() -> A.method(), "Thread-A").start();

        new Thread(() -> B.method(), "Thread-B").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }
}

class A {

    private static final Logger LOGGER = LogManager.getLogger(A.class);

    public static synchronized void method() {

        LOGGER.info("method from A");

        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }
}

class B {

    private static final Logger LOGGER = LogManager.getLogger(B.class);

    public static synchronized void method() {

        LOGGER.info("method from B");

        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }
}
