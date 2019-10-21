package com.soup.memo.jvm8.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-30 21:59
 * @since 1.0
 */
public class ClassLoader6 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String resourceName = "com/dev/jvm/classloader/ClassLoader5.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }
    }
}
