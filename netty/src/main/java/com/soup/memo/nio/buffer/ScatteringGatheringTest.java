package com.soup.memo.nio.buffer;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-03 10:17
 */
public class ScatteringGatheringTest {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        socketChannel.bind(address);

        int messageLen = 2 + 3 + 4;

        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel channel = socketChannel.accept();

        while (true) {
            int byteRead = 0;
            while (byteRead < messageLen) {
                long r = channel.read(buffers);
                byteRead += r;

                System.out.println("byteReads: " + byteRead);

                Arrays.stream(buffers).map(buffer -> "positon: " + buffer.position() + ", limit" + buffer.limit())
                                .forEach(System.out::println);
            }

            Arrays.asList(buffers).forEach(Buffer::flip);

            long byteWritten = 0;
            while (byteWritten < messageLen) {
                long r = channel.write(buffers);
                byteWritten += r;
            }
            Arrays.asList(buffers).forEach(Buffer::clear);

            System.out.println("byteRead: " + byteRead + ", byteWritten: " + byteWritten + ", messageLen: " + messageLen);
        }
    }
}
