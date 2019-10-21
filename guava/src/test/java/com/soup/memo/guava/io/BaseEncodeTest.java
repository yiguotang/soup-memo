package com.soup.memo.guava.io;

import com.google.common.io.BaseEncoding;
import org.junit.Test;

/**
 * @author zhaoyi
 * @description BaseEncode
 * @date 2019-05-01 15:13
 **/
public class BaseEncodeTest {
    @Test
    public void testBase64Encode() {
        BaseEncoding baseEncoding = BaseEncoding.base64();
        System.out.println(baseEncoding.encode("hello".getBytes()));
    }

    @Test
    public void testBase64Decode() {
        BaseEncoding baseEncoding = BaseEncoding.base64();
        System.out.println(baseEncoding.decode("aGVsbG8="));
    }
}
