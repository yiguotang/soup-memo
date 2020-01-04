package com.soup.memo.jvm8.classloader;

import lombok.extern.slf4j.Slf4j;

/**
 * 打印 AppClassLoader 和 ExtClassLoader 的加载信息
 *
 * @author zhaoyi
 */
@Slf4j
public class ClassLoaderProperties {
    public static void main(String[] args) {
        log.info("ExtClassLoader ext dirs: {}", System.getProperty("java.ext.dirs"));
        log.info("AppClassLoader ext dirs: {}", System.getProperty("java.class.path"));
    }
}
