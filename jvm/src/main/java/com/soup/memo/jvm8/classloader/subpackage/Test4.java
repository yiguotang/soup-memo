package com.soup.memo.jvm8.classloader.subpackage;

import com.soup.memo.jvm8.classloader.MyClassLoader;

import java.lang.reflect.Method;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-05 21:25
 * @since 1.0
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        MyClassLoader loader2 = new MyClassLoader("loader2");

        loader1.setPath("D:\\Documents\\Desktop\\");
        loader2.setPath("D:\\Documents\\Desktop\\");

        Class<?> clazz1 = loader1.loadClass("com.dev.jvm.classloader.subpackage.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.dev.jvm.classloader.subpackage.MyPerson");

        // true
        System.out.println(clazz1 == clazz2);

        Object obj1 = clazz1.newInstance();
        Object obj2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setPerson", Object.class);
        method.invoke(obj1, obj2);

    }
}
