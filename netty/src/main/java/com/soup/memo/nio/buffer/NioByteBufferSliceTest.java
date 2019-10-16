package com.soup.memo.nio.buffer;

import java.nio.ByteBuffer;

/**
 * <p>
 * Description: ByteBuffer的slice方法测试
 * slice buffer与原有的buffer共享同一份数据
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-02 20:23
 */
public class NioByteBufferSliceTest {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        for (int i = 0; i < byteBuffer.capacity(); ++i) {
            byteBuffer.put((byte) i);
        }

        byteBuffer.position(2);
        byteBuffer.limit(6);

        ByteBuffer sliceBuffer = byteBuffer.slice();
        for (int i = 0; i < sliceBuffer.capacity(); ++i) {
            byte b = sliceBuffer.get(i);
            b *= 2;
            sliceBuffer.put(i, b);
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());

        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }
}
