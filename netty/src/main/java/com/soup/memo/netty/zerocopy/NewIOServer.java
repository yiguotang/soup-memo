package com.soup.memo.netty.zerocopy;

import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author zhaoyi
 * @description 零拷贝的服务端
 * @date 2019-04-07 22:49
 **/
@Slf4j
public class NewIOServer {

    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            // 没有selector，设置成阻塞模式
            socketChannel.configureBlocking(true);

            int readCount = 0;
            while (-1 != readCount) {
                readCount = socketChannel.read(byteBuffer);

                byteBuffer.rewind();
            }
        }
    }
}
