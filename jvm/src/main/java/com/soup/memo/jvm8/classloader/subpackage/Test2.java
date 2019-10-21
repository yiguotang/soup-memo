package com.soup.memo.jvm8.classloader.subpackage;

import com.soup.memo.jvm8.classloader.MyClassLoader;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-05 0:29
 * @since 1.0
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("loader1");

        Class<?> clazz = classLoader.loadClass("com.dev.jvm.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader: " + clazz.getClassLoader());

        // 将MySample移动到根类加载器的加载目录中，再执行查看结果
    }
}
