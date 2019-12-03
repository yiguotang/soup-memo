package com.soup.memo.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * BigDecimal Test
 *
 * @author zhaoyi
 */
@Slf4j
public class BigDecimalTest {

    @Test
    public void compareToTest() {
        // BigDecimal compareTo 方法结果
        log.info("BigDecimal compareTo result: {}", new BigDecimal("0.1").compareTo(BigDecimal.ZERO));
    }
}
