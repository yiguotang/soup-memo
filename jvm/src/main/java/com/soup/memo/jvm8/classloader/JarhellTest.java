package com.soup.memo.jvm8.classloader;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author zhaoyi
 * @description Jar hell问题以及解决办法
 * @date 2019-03-30 13:45
 **/
@Slf4j
public class JarhellTest {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resourceName = "java/lang/String.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            log.info("{}", url);
        }
    }
}
