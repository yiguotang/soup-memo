package com.soup.memo.jvm8.bytecode;

/**
 * 可变参数方法的重载方法的一个坑
 * 重载方法是在编译期就可以确认调用方法
 *
 * @author zhaoyi
 */
public class InvokeOverload {
    public static void invoke(Object obj, Object... objs) {
        System.out.println("hello");
    }

    public static void invoke(String str, Object obj, Object... objs) {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        // 都调用了第二个重载的方法
        InvokeOverload.invoke(null, 1);
        InvokeOverload.invoke(null, null, 1);

        // 手动绕开，才能调用第一个方法
        InvokeOverload.invoke(null, new Object[]{1});
    }
}
