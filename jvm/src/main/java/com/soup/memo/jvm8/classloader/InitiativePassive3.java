package com.soup.memo.jvm8.classloader;

import java.util.UUID;

/**
 * 当一个常量的值并非编译期间可以确定的，那么其值就不会放到调用类的常量池中，
 * 这时在程序运行时，会导致主动使用这个类的常量所在的类，显然会导致这个类（Parent3）被初始化
 *
 * @author zhaoyi
 * @date 2019-01-27 0:18
 * @since 1.0
 */
public class InitiativePassive3 {
    public static void main(String[] args) {
        System.out.println(Parent3.str);
    }
}

class Parent3 {

    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("Parent3 static code!");
    }
}
