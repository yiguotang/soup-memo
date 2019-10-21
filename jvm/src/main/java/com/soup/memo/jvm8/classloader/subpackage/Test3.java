package com.soup.memo.jvm8.classloader.subpackage;

import com.soup.memo.jvm8.classloader.MyClassLoader;

import java.lang.reflect.Method;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-05 0:40
 * @since 1.0
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        MyClassLoader loader2 = new MyClassLoader("loader2");

        // 根据双亲委托机制，loader1会委托父加载器(系统类加载器)加载，这样系统类加载器会加载MyPerson类
        Class<?> clazz1 = loader1.loadClass("com.dev.jvm.classloader.subpackage.MyPerson");
        // 根据双亲委托机制，loader2会委托父加载器(系统类加载器)加载，此时系统类加载器已经加载了MyPerson类，则直接返回MyPerson类的对象，clazz1与clazz2对象都是同一个对象
        Class<?> clazz2 = loader2.loadClass("com.dev.jvm.classloader.subpackage.MyPerson");

        // false
        System.out.println(loader1 == loader2);

        // true
        System.out.println(clazz1 == clazz2);

        Object obj1 = clazz1.newInstance();
        Object obj2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setPerson", Object.class);
        method.invoke(obj1, obj2);

    }
}

class MyPerson {
    private MyPerson person;

    public void setPerson(Object person) {
        this.person = (MyPerson) person;
    }
}
