package com.soup.memo.nio.buffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 * Description: nio的文件通道用法
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-01 16:10
 */
public class NioFileChannel {

    private static final Logger LOGGER = LogManager.getLogger(NioFileChannel.class);

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("settings.gradle");
        File targetFile = new File("demo");
        FileOutputStream outputStream = new FileOutputStream(targetFile);

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            /**
             * 将缓存恢复到初始状态：position=0，limit=capacity
             * 下面一条语句注释后会发生不断写入数据，原因是：
             * 如果注释了话，当buffer的position和limit都读取完数据后，在最后一个索引位置上，
             * int read = inputChannel.read(byteBuffer);
             * 执行完后，写入数据，由于position与limit值一样，position无法再写入数据，返回的是0，即read是0，无法结束循环
             * 执行flip翻转后，position又回到开始0的位置，又将数据写入到目标文件中
             */
            byteBuffer.clear();

            int read = inputChannel.read(byteBuffer);
            LOGGER.info("read: {}", read);
            if (-1 == read) {
                break;
            }

            /**
             * flip()方法的作用是将limit的值设置为position，position设置为0
             */
            byteBuffer.flip();

            outputChannel.write(byteBuffer);
        }

        inputChannel.close();
        outputChannel.close();

        // 后续操作
        if (targetFile.exists()) {
            System.out.println("after process del targetFile: " + targetFile.delete());
        }

        inputStream.close();
        outputStream.close();
    }
}
