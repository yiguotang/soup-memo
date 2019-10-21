package com.soup.memo.guava.io;

import com.google.common.io.CharSource;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zhaoyi
 * @description CharsourceWrap
 * @date 2019-04-30 21:01
 **/
public class CharSourceWrap {

    @Test
    public void wrap() throws IOException {
        CharSource charSource = CharSource.wrap("CharSource test");
        String resulrAsRead = charSource.read();
        Assert.assertThat(resulrAsRead, IsEqual.equalTo("CharSource test"));
    }
}
