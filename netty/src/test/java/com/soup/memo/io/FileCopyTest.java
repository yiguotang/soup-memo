package com.soup.memo.io;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.soup.memo.FileCoy;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

/**
 * 三种文件copy的测试
 *
 * @author zhaoyi
 */
@Slf4j
public class FileCopyTest {

    /**
     * 传统io方式copy
     */
    @Test
    public void traditionalCopyTest() throws Exception {
        File source = new File("F:/workspace/scrps_git.zip");

        File targetDest = new File("F:/scrps_git1.zip");

        if (!targetDest.exists()) {
            boolean createResult = targetDest.createNewFile();
            log.debug("targetpath file create result: {}", createResult);
        }

        TimeInterval interval = DateUtil.timer();

        // 传统IO方式拷贝
        FileCoy.traditionalCopy(source, targetDest);
        log.info("传统IO方式拷贝花费时间 {} 毫秒", interval.intervalRestart());

    }

    /**
     * nio fileChannel方式copy
     */
    @Test
    public void nioCopyTest() throws Exception {
        File source = new File("F:/workspace/scrps_git.zip");

        File targetDest = new File("F:/scrps_git2.zip");

        if (!targetDest.exists()) {
            boolean createResult = targetDest.createNewFile();
            log.debug("targetpath file create result: {}", createResult);
        }

        TimeInterval interval = DateUtil.timer();

        // nio FileChannel方式拷贝
        FileCoy.nioCopy(source, targetDest);
        log.info("FileChannel方式拷贝花费时间 {} 毫秒", interval.intervalRestart());
    }

    /**
     * nio MappedByteBuffer方式copy
     */
    @Test
    public void nioCopyByMappedByteBufferTest() throws Exception {
        File source = new File("F:/workspace/scrps_git.zip");

        File targetDest = new File("F:/scrps_git3.zip");

        if (!targetDest.exists()) {
            boolean createResult = targetDest.createNewFile();
            log.debug("targetpath file create result: {}", createResult);
        }

        TimeInterval interval = DateUtil.timer();

        // nio MappedByteBuffer方式拷贝
        FileCoy.nioCopyByMappedByteBuffer(source, targetDest);
        log.info("MappedByteBuffer方式拷贝花费时间 {} 毫秒", interval.intervalRestart());
    }
}
