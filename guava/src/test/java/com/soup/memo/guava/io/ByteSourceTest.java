package com.soup.memo.guava.io;

import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author zhaoyi
 * @description ByteSource
 * @date 2019-05-01 10:43
 **/
public class ByteSourceTest {

    private final String path = "D:\\Workspace\\dev\\guava\\src\\test\\java\\com\\dev\\guava\\io\\ByteSourceTest.java";

    @Test
    public void testAsByteSource() throws IOException {
        File file = new File(path);
        ByteSource byteSource = Files.asByteSource(file);
        byte[] readBytes = byteSource.read();

        Assert.assertThat(readBytes, Is.is(Files.toByteArray(file)));
    }


}
