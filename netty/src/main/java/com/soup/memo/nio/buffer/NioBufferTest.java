package com.soup.memo.nio.buffer;

import java.nio.ByteBuffer;

/**
 * <p>
 * Description: buffer的测试，展示类型化的get和put方法
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-02 19:50
 */
public class NioBufferTest {

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        byteBuffer.putInt(15);
        byteBuffer.putLong(50000000L);
        byteBuffer.putDouble(0.12);
        byteBuffer.putChar('你');
        byteBuffer.putChar('我');

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getChar());
    }

}
