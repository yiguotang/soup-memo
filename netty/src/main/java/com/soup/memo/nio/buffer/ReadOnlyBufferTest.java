package com.soup.memo.nio.buffer;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * <p>
 * Description: 只读buffer
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-02 20:34
 */
@Slf4j
public class ReadOnlyBufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        log.info("ByteBuffer class: {}", buffer.getClass());

        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte) i);
        }

        // 转换成只读，生成一个新的对象，本例中是HeapByteBufferR对象实例
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        // 只读的buffer实现方式，在对应类的put方法中直接抛出ReadOnlyBufferException异常

        log.info("readOnlyBuffer class: {}", readOnlyBuffer.getClass());
    }
}
