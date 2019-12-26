package com.soup.memo.jvm8.classloader;

import lombok.extern.slf4j.Slf4j;

/**
 * 类初始化顺序
 *
 * @author zhaoyi
 */
@Slf4j
public class ClassInitializeOrder {

    public static void main(String[] args) {
        // 依照代码的顺序执行初始化，输出的结果是 4
        log.info("{}", A.a);

        // B的顺序是，则结果是1
        log.info("{}", B.a);
    }
}

class A {

    public static int a = 1;

    static {
        a = 4;
    }
}

class B {

    static {
        a = 4;
    }

    public static int a = 1;
}