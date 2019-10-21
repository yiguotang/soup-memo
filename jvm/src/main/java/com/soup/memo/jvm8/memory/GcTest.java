package com.soup.memo.jvm8.memory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <p>
 * Description:
 * -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-02 15:25
 */
public class GcTest {

    private static final Logger LOGGER = LogManager.getLogger(MetaSpaceTest.class);

    public static void main(String[] args) {
        LOGGER.info("test gc collector CMS");
    }
}
