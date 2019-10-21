package com.soup.memo.common;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * List Array Test
 *
 * @author zhaoyi
 */
@Slf4j
public class ListArrayTest {

    @Test
    public void List2ArrayTest() {
        List<String> list = Lists.newArrayList("test1", "test2", "test3");
        log.info("origin list: {}", list);
        String[] listArr = new String[list.size()];
        listArr = list.toArray(listArr);
        log.info("list to arr len: {}", listArr.length);
    }
}
