package com.soup.memo.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 序列号的一些测试
 *
 * @author zhaoyi
 */
@Slf4j
public class NumberTest {

    @Test
    public void padTest() {
        Long number = Long.parseLong(StringUtils.rightPad("1", 10, '0'));
        log.info("{}", number);

        log.info("{}", 245230 % 1000000000);
    }

}
