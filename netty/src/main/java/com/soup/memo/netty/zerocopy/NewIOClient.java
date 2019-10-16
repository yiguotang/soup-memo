package com.soup.memo.netty.zerocopy;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyi
 * @description 零拷贝的客户端
 * @date 2019-04-07 23:00
 **/
@Slf4j
public class NewIOClient {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);

        String fileName = "D:\\Downloads\\goland-2018.1.6.exe";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        Stopwatch stopwatch = Stopwatch.createStarted();

        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        log.info("发送字节数: {}, 耗时: {}ms", transferCount, stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));

        fileChannel.close();
    }
}
