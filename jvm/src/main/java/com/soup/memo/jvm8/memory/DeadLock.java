package com.soup.memo.jvm8.memory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoyi
 * @description 死锁示例
 * @date 2019-03-24 21:34
 **/
@Slf4j
public class DeadLock {

    public static void main(String[] args) {

        new Thread(() -> A.method(), "Thread-A").start();

        new Thread(() -> B.method(), "Thread-B").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("method invoke occur Exception!");
        }
    }
}

class A {

    public static synchronized void method() {

        System.out.println("method from class A");

        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            System.out.println("method invoke from class A occur Exception!");
        }
    }
}

class B {

    public static synchronized void method() {

        System.out.println("method from class B");

        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            System.out.println("method invoke from class B occur Exception!");
        }
    }
}
