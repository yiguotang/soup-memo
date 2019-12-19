package com.soup.memo.jvm8.memory;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description:
 * -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-02 15:25
 */
@Slf4j
public class GcTest {

    public static void main(String[] args) {
        log.info("test gc collector CMS");
    }
}
