package com.soup.memo.nio;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * <p>
 * Description: 初识nio。输出一个随机数字
 * </p>
 *
 * @author zhaoyi
 * @date 2019-03-04 23:52
 * @since 1.0
 */
@Slf4j
public class NioFirstMetDemo {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < 5; i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        log.info("before buffer.flip() limit val: {}", buffer.limit());
        log.info("before buffer.flip() position val: {}", buffer.position());

        buffer.flip();

        log.info("after buffer.flip() limit val: {}", buffer.limit());

        while (buffer.hasRemaining()) {
            log.info("limit: {}", buffer.limit());
            log.info("posiont: {}", buffer.position());
            log.info("capacity: {}", buffer.capacity());
            log.info("buffer.get(): {}", buffer.get());
        }
    }
}
