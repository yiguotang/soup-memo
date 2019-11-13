package com.soup.memo;

import cn.hutool.core.io.IoUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件拷贝 <br/>
 * 分别测试传统io和nio的方式拷贝文件的性能
 *
 * @author zhaoyi
 */
@Slf4j
public class FileCoy {

    /**
     * 传统IO方式拷贝文件
     *
     * @param source 源文件
     * @param dest 目标文件
     */
    public static void traditionalCopy(File source, File dest) {

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            // 这里使用 hutool 的工具类进行文件拷贝
            long copySize = IoUtil.copy(fis, fos, IoUtil.DEFAULT_BUFFER_SIZE);
            log.debug("traditionalCopy file copy size: {}", copySize);
        } catch (IOException e) {
            log.error("create inputstream/outputstream obj occur error!", e);
        }
    }

    /**
     * 使用nio的FileChannel进行文件拷贝，通过通道对文件进行读写
     *
     * @param source 源文件
     * @param dest 源文件
     */
    public static void nioCopy(File source, File dest) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            FileChannel sourceFileChannel = fis.getChannel();
            FileChannel targetFileChannel = fos.getChannel();

            targetFileChannel.transferFrom(sourceFileChannel, 0, sourceFileChannel.size());

            sourceFileChannel.close();
            targetFileChannel.close();
        } catch (IOException e) {
            log.error("create inputstream/outputstream obj occur error!", e);
        }
    }

    /**
     * 使用nio中的文件映射方式进行文件拷贝
     *
     * @param source 源文件
     * @param dest 目标文件
     */
    public static void nioCopyByMappedByteBuffer(File source, File dest) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            FileChannel sourceFileChannel = fis.getChannel();
            FileChannel targetFileChannel = fos.getChannel();

            MappedByteBuffer mappedByteBuffer = sourceFileChannel.map(FileChannel.MapMode.READ_ONLY,
                    0, sourceFileChannel.size());
            targetFileChannel.write(mappedByteBuffer);

            sourceFileChannel.close();
            targetFileChannel.close();
        } catch (IOException e) {
            log.error("create inputstream/outputstream obj occur error!", e);
        }
    }
}
