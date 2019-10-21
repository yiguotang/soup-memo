package com.soup.memo.jvm8.classloader;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-02 15:00
 * @since 1.0
 */
public class ClassLoader7 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("========");

        Parent[] parents = new Parent[2];
        System.out.println(parents.getClass().getClassLoader());

        System.out.println("=======");

        int[] ints = new int[2];
        // 虽然返回的是null，但是不代表是根类加载器，表示的是没有classloader
        System.out.println(ints.getClass().getClassLoader());
    }
}
