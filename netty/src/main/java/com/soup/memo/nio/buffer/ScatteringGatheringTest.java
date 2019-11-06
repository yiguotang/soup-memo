package com.soup.memo.nio.buffer;

import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * <p>
 * Description: 关于buffer的Scattering（散开）和Gathering（收集）
 *  Scattering将来自一个channel中的数据读到多个buffer中，总是按照顺序，只有把第一个读满了才往下一个buffer读
 *  而Gathering与之相反
 *  这个多用于自定义协议中，定义各部分的长度（各个部分设定长度的buffer），使用Scattering（散开）和Gathering天然实现数据的分门别类
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-03 10:17
 */
@Slf4j
public class ScatteringGatheringTest {

    /**
     * 启动一个服务端，使用telnet或nc做为客户端进行测试
     */
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

            // 如果读到的字节数小于总的buffer定义的字节数，则终止
            while (byteRead < messageLen) {

                long r = channel.read(buffers);
                // 统计实际读到的字节数量
                byteRead += r;

                log.info("byteReads: {}", byteRead);

                // 每次读完后将buffer数组的每个元素的position、limit打印出来
                Arrays.stream(buffers).map(buffer -> "positon: " + buffer.position() + ", limit" + buffer.limit())
                                .forEach(log::info);
            }

            // 对每一个buffer执行flip操作
            Arrays.asList(buffers).forEach(Buffer::flip);

            // 将buffer写回客户端
            long byteWritten = 0;
            while (byteWritten < messageLen) {
                long r = channel.write(buffers);
                byteWritten += r;
            }

            // 对每一个buffer执行clear操作
            Arrays.asList(buffers).forEach(Buffer::clear);

            log.info("byteRead: {}, byteWritten: {}, messageLen: {} ", byteRead, byteWritten, messageLen);
        }
    }
}
