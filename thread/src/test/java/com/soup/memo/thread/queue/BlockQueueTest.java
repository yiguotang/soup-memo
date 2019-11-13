package com.soup.memo.thread.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 自定义阻塞队列测试
 *
 * @author zhaoyi
 */
@Slf4j
public class BlockQueueTest {

    @Test
    public void blockQueueTest() throws Exception {
        BlockQueue blockQueue = new BlockQueue(5);

        blockQueue.put("a");
        blockQueue.put("b");
        blockQueue.put("c");
        blockQueue.put("d");
        blockQueue.put("e");

        log.info("current queue length: {}", blockQueue.queueSize());

        Thread t1 = new Thread(() -> {
            blockQueue.put("f");
            blockQueue.put("g");
            blockQueue.put("h");
        }, "t1");

        Thread t2 = new Thread(() -> {
            blockQueue.get();
            blockQueue.get();
        }, "t2");

        t1.start();
        TimeUnit.SECONDS.sleep(10);

        t2.start();
    }
}
