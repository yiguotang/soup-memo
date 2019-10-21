package com.soup.memo.jvm8.classloader;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-27 23:05
 * @since 1.0
 */
public class ClassLoad1 {

    public static void main(String[] args) throws Exception {

        // 加载String类
        Class<?> stringClass = Class.forName("java.lang.String");

        // 获取String类的class loader，某些类的返回是null，则表示是boostrap calss loader
        ClassLoader classLoader = stringClass.getClassLoader();
        System.out.println(classLoader);

        System.out.println("------------");

        Class<?> clazz = Class.forName("com.dev.jvm.classloader.Sample");
        System.out.println(clazz.getClassLoader());
    }
}

class Sample {

}
