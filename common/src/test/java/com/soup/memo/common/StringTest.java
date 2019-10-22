package com.soup.memo.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * String Test
 *
 * @author zhaoyi
 */
@Slf4j
public class StringTest {

    /**
     * 测试字符串截取
     */
    @Test
    public void strSubstringTest() {
        String str = ",ceshi,test,";
        log.info(str.substring(0, str.length()-1));
    }
}
