package com.soup.memo.jvm8.classloader.subpackage;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-05 0:20
 * @since 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        // 根类加载器加载路径
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println();

        // 扩展类加载器加载路径
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println();

        // 应用类加载器的加载路径
        System.out.println(System.getProperty("java.class.path"));
        System.out.println();
    }
}
