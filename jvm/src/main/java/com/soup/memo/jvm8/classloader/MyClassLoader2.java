package com.soup.memo.jvm8.classloader;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-03 22:51
 * @since 1.0
 */
public class MyClassLoader2 {

    public static void main(String[] args) throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        Class<?> clazz = loader1.loadClass("com.dev.jvm.classloader.MySample");
        System.out.println("class： " + clazz.hashCode());

        // 执行到这个地方，并没有实例化MySample对象，MySample类的构造方法不会被调用
        // 也不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat，可以从jvm参数-XX:+TraceClassLoading可以看出

        //Object obj = clazz.newInstance();
    }
}
