package com.soup.memo.nio.buffer;

import java.nio.ByteBuffer;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-02 20:34
 */
public class NioReadOnlyBufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte) i);
        }

        // 转换成只读，生成一个新的对象，本例中是HeapByteBufferR对象实例
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        // 只读的buffer实现方式，在对应类的put方法中直接抛出ReadOnlyBufferException异常
    }
}
