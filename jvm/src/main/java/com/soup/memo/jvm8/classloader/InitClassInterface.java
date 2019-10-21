package com.soup.memo.jvm8.classloader;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-27 20:59
 * @since 1.0
 */
public class InitClassInterface {
    public static void main(String[] args) {
        /**
         * Parent6中定义的静态变量的值的匿名内部类的代码块没有执行，原因是：初始化一个类时，并不会初始化它所实现的接口
         * 但Parent6会被加载，从-XX:+TraceClassLoading可以看出，这表示类被加载，不一定会被初始化
         *
         */
        // System.out.println(Child4.b);
        // System.out.println(Child5.b);

        /**
         * 在初始化一个接口时，并不会先初始化他的父接口
         * 同样从-XX:+TraceClassLoading可以看出，父接口也被加载了，但是并未进行初始化
         */
        System.out.println(Child6.thread);
    }
}

interface Parent6 {
    /**
     * 如果Parent6类被初始化，则类的这个静态变量thread会被赋值
     * thread被赋值，则new Thread() {} 匿名内部类被创建，则匿名内部类中的代码块一定会执行，这个代码块是类每次实例化都会被执行，而且先于构造方法
     * 如果匿名内部类的代码块被执行，则表示Parent6被初始化了
     */
    public static Thread thread = new Thread() {
        {
            System.out.println("Parent6 invoked!");
        }
    };
}

class Child4 implements Parent6 {
    public static int b = 5;
}

interface Parent7 extends Parent6 {
    public static Thread thread = new Thread() {
        {
            System.out.println("Parent7 invoked!");
        }
    };
}

class Child5 implements Parent7 {
    public static int b = 5;
}

interface Grandpa {
    public static Thread thread = new Thread() {
        {
            System.out.println("Grandpa invoked!");
        }
    };
}

interface Child6 extends Grandpa {
    public static Thread thread = new Thread() {
        {
            System.out.println("Child6 invoked!");
        }
    };
}

// 演示代码块
class C {
    {
        System.out.println("hello");
    }

    public C() {
        System.out.println("C");
    }
}
