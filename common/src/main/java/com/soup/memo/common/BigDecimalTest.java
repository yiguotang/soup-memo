package com.soup.memo.common;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * BigDecimal Test
 *
 * @author zhaoyi
 */
@Slf4j
public class BigDecimalTest {

    public static void main(String[] args) {

        // BigDecimal compareTo 方法结果
        log.info("BigDecimal compareTo result: {}", new BigDecimal("0.1").compareTo(BigDecimal.ZERO));
    }
}
