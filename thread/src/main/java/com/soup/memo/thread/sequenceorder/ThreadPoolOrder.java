package com.soup.memo.thread.sequenceorder;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用 newSingleThreadExecutor() 实现线程顺序执行
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class ThreadPoolOrder {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; ++i) {
            final int number = i;
            pool.execute(() -> log.info("thread - {}: do something", number));
        }
        pool.shutdown();
    }
}
