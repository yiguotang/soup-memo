package com.soup.memo.jvm8.classloader;

import lombok.extern.slf4j.Slf4j;

/**
 * 验证数组类型的类加载器
 *
 * @author zhaoyi
 */
@Slf4j
public class ArrayTypeClassLoader {

    public static void main(String[] args) {

        String[] strings = new String[2];
        log.info("String[] class: {}, classLoader: {}", strings.getClass(), strings.getClass().getClassLoader());

        ArrayTypeClassLoader[] objArr = new ArrayTypeClassLoader[2];
        log.info("Object[] class: {}, classLoader: {}", objArr.getClass(), objArr.getClass().getClassLoader());

        ArrayTypeClassLoader[] objArr2 = new ArrayTypeClassLoader[2];
        log.info("Object[] class: {}, classLoader: {}", objArr2.getClass(), objArr2.getClass().getClassLoader());

        int[] intArr = new int[2];
        log.info("int[] class: {}, classLoader: {}", intArr.getClass(), intArr.getClass().getClassLoader());
    }
}
