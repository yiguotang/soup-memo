package com.soup.memo.thread.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger 测试
 *
 * @author zhaoyi
 */
@Slf4j
public class AtomicIntegerTest {

    @Test
    public void incrementAndGetTest() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        log.info("{}", atomicInteger.incrementAndGet());
    }
}
