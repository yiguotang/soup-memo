package com.soup.memo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoyi
 * @description 死锁的示例，使用可视化工具(如jconsole)查看
 * @date 2019-03-24 20:52
 **/
@Slf4j
public class DeadLock {

    private static String A = "A";
    private static String B = "B";

    private void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (B) {
                    System.out.println("1");
                }
            }
        }, "Thread-01");

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("2");
                }
            }
        }, "Thread-02");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLock().deadLock();
    }
}
