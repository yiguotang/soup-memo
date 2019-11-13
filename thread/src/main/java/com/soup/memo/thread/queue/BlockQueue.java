package com.soup.memo.thread.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义阻塞队列
 *
 * @author zhaoyi
 */
@Slf4j
public class BlockQueue {

    /**
     * 数据集合
     */
    private LinkedList<Object> queue = new LinkedList<>();

    /**
     * 计数器，存储队列中有多少元素
     */
    private AtomicInteger count = new AtomicInteger(0);

    /**
     * 锁对象
     */
    private final Object lock = new Object();

    private final int minSize = 0;
    private final int maxSize;

    public BlockQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 添加元素到队列，如果队列已满，则调用阻塞方法等待，直到有多余空间再添加
     */
    public void put(Object obj) {
        synchronized (lock) {
            // 判断队列是否已满，如果已满则阻塞等待
            while (count.get() == this.maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("block queue occur error! put obj ", e);
                }
            }

            // 添加元素
            queue.add(obj);

            // 计数器递增
            count.incrementAndGet();

            log.info("新加的元素：{}", obj);

            // 唤醒其他线程
            lock.notify();
        }
    }

    /**
     * 从队列中取出元素
     */
    public Object get() {
        Object result = null;

        synchronized (lock) {
            while (count.get() == this.minSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("block queue occur error! get object ", e);
                }
            }

            result = queue.removeFirst();
            count.decrementAndGet();
            log.info("获取并从队列中移除的元素：{}", result);

            lock.notify();
        }

        return result;
    }

    /**
     * 获取队列大小
     */
    public int queueSize() {
        return this.count.get();
    }

}
