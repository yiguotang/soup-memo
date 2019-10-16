package com.soup.memo.nio.buffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhaoyi
 * @description nio方式读取文件
 * @date 2019-03-31 22:34
 **/
public class NioReadFile {

    private static final Logger LOGGER = LogManager.getLogger(NioReadFile.class);

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("build.gradle");
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            LOGGER.info("character: {}", b);
        }

        fileChannel.close();
        fileInputStream.close();
    }
}
