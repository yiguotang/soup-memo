package com.soup.memo.guava.io;

import com.google.common.io.ByteSource;
import com.google.common.io.Closer;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhaoyi
 * @description Closer
 * @date 2019-05-01 11:11
 **/
public class CloserTest {

    @Test
    public void testCloser() throws IOException {
        ByteSource byteSource = Files.asByteSource(new File("D:\\Workspace\\dev\\guava\\src\\test\\java\\com\\dev\\guava\\io\\CloserTest.java"));
        Closer closer = Closer.create();
        try {
            InputStream in = closer.register(byteSource.openStream());
        } catch (IOException e) {
            throw closer.rethrow(e);
        } finally {
            closer.close();
        }
    }
}
