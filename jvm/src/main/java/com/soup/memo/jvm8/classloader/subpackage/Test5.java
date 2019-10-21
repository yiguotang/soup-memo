package com.soup.memo.jvm8.classloader.subpackage;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-05 22:02
 * @since 1.0
 */
public class Test5 {
    static {
        System.out.println("Test5 initializer");
    }

    // 使用java -Djava.ext.dirs=./ com.dev.jvm.classloader2.Test5来修改扩展类加载器的目录
    public static void main(String[] args) {
        System.out.println(Test5.class.getClassLoader());

        System.out.println(Test1.class.getClassLoader());

        System.out.println(System.getProperty("java.system.class.loader"));
    }
}
