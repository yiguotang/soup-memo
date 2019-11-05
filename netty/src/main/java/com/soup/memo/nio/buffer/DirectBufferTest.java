package com.soup.memo.nio.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-02 21:06
 */
public class DirectBufferTest {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("settings.gradle");
        File targetFile = new File("demo");
        FileOutputStream outputStream = new FileOutputStream(targetFile);

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        while (true) {
            byteBuffer.clear();

            int read = inputChannel.read(byteBuffer);
            if (-1 == read) {
                break;
            }

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
