package com.soup.memo.jvm8.classloader;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-30 13:29
 */
public class ClassLoader4 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = classLoader.loadClass("com.dev.jvm.classloader.CL");
        // 并未初始化类CL，调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
        System.out.println(clazz);

        System.out.println("--------");

        clazz = Class.forName("com.dev.jvm.classloader.CL");
        // 初始化类CL，属于主动使用类的七种情况之一：反射，Class.forName
        System.out.println(clazz);
    }
}

class CL {
    static {
        System.out.println("Class CL");
    }
}
