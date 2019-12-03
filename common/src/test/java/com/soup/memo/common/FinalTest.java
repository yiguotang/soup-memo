package com.soup.memo.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Final 变量测试
 *
 * @author zhaoyi
 */
@Slf4j
public class FinalTest {
    static final int i = 99;

    @Test
    public void testFinal() {
        for (int i = 0; i < 100; i++) {
            log.info("in loop i value: {}", i);
            i++;
            break;
        }

        log.info("after loop i value: {}", i);
    }
}
