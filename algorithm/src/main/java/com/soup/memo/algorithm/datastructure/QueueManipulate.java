package com.soup.memo.algorithm.datastructure;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 循环队列操作：出队和入队
 *
 * @author zhoayi
 */
@Slf4j
@Data
public class QueueManipulate {

    private int[] array;

    private int front;

    private int rear;

    public QueueManipulate(int size) {
        this.array = new int[size];
    }

    /**
     * 入队操作
     */
    public void enQueue(int elemet) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满");
        }

        array[rear] = elemet;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出栈
     */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空，无元素");
        }

        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    /**
     * 打印队列元素
     */
    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            log.info("队列中第{}个元素：{}", i+1, array[i]);
        }
    }
}
