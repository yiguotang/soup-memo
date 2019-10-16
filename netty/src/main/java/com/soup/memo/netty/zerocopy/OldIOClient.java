package com.soup.memo.netty.zerocopy;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyi
 * @description 传统方式，非零拷贝的方式，客户端
 * @date 2019-04-07 22:40
 **/
@Slf4j
public class OldIOClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 8899);

        // 模拟文件传输，使用一个磁盘上的大文件
        String fileName = "D:\\Downloads\\goland-2018.1.6.exe";
        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;

        Stopwatch stopwatch = Stopwatch.createStarted();

        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        log.info("发送字节数: {}, 耗时: {}ms", total, stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));

        inputStream.close();
        dataOutputStream.close();
    }
}
