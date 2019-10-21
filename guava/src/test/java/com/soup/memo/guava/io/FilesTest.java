package com.soup.memo.guava.io;

import com.google.common.io.Files;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-03-28 14:27
 */
public class FilesTest {

    private File sourceFile;
    private File targetFile;

    @Before
    public void init() {
        String sourceFileName = "files.test";
        sourceFile = getResource(sourceFileName);
        String targetPath = "F:\\workspace\\dev\\guava\\src\\test\\resources\\files.test.copy";
        targetFile = new File(targetPath);
    }

    /**
     * guava Files 复制文件
     */
    @Test
    public void copyFile() {
        try {
            Files.copy(sourceFile, targetFile);
            Assert.assertThat(targetFile.exists(), IsEqual.equalTo(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * jdk nio Files 复制文件
     */
    @Test
    public void copyFileWithJdk() {
        String sourcePathUir = "";
        String targetPathUir = "";

        try {
            java.nio.file.Files.copy(Paths.get(sourcePathUir), Paths.get(targetPathUir), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 移动文件
     */
    @Test
    public void moveFileTest() {
        try {
            Files.move(sourceFile, targetFile);
            Assert.assertThat(sourceFile.exists(), IsEqual.equalTo(false));
            Assert.assertThat(targetFile.exists(), IsEqual.equalTo(true));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 单元测试后，进行清理工作
     */
    @After
    public void tearDown() {
        String targetPath = "F:\\workspace\\dev\\guava\\src\\test\\resources\\files.test.copy";
        File targetFile = new File(targetPath);
        if (targetFile.exists()) {
            System.out.println(targetFile.delete());
        }
    }

    /**
     * 获取resources下的文件
     * @param file 文件名
     * @return File
     */
    private static File getResource(String file) {
        URL url = FilesTest.class.getClassLoader().getResource(file);
        if (Objects.nonNull(url)) {
            return new File(url.getPath());
        }
        return null;
    }
}
