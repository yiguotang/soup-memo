package com.soup.memo.algorithm.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 循环队列测试
 *
 * @author zhaoyi
 */
@Slf4j
public class QueueManipulateTest {
    @Test
    public void test() throws Exception {
        QueueManipulate queue = new QueueManipulate(6);

        // 入队
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(8);
        queue.enQueue(1);

        queue.output();
        log.info("================分割线================");

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        queue.output();
        log.info("================分割线================");

        queue.enQueue(2);
        queue.enQueue(4);
        queue.enQueue(9);

        queue.output();
    }
}
