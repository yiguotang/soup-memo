package com.soup.memo.jvm8.classloader;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-29 12:37
 */
public class ClassLoader3 {

    static {
        System.out.println("classloader static block");
    }

    public static void main(String[] args) {
        // 执行顺序： ClassLoader3类的静态代码块，ParentTest1类的静态代码块，ChildTest1类的静态代码块，ChildTest1类的b
        System.out.println(ChildTest1.b);
    }
}

class ParentTest1 {
    static int a = 3;

    static {
        System.out.println("parenttest static block");
    }
}

class ChildTest1 extends ParentTest1 {
    static int b = 4;

    static {
        System.out.println("childTest static block");
    }
}
