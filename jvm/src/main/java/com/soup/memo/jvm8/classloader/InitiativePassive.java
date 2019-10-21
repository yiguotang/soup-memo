package com.soup.memo.jvm8.classloader;

/**
 * <p>
 * Description: 程序对类的使用：主动和被动使用
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-25 16:21
 */
public class InitiativePassive {

    /**
     * main方法是标记这是一个主动类，会被加载
     * @param args
     */
    public static void main(String[] args) {

        /**
         *  对于静态字段来说，只有直接定义了该字段的类才会被初始化，
         *  本行代码是子类代码中调用父类的静态变量，因此这个是对Parant类的主动使用，
         *  这里的str是父类中定义的，虽然使用子类进行引用，但并没有主动使用Child中的，没有满足“首次主动使用”的初始化,
         *  那么子类有没有被加载呢？
         *  添加参数：-XX:+TraceClassLoading，用于追踪类的加载信息并打印出来，
         *  <p>
         *      [Loaded com.dev.jvm.classloader.Parent from file:/D:/VCS/Git/dev/dev-jvm/out/production/classes/]
         *      [Loaded com.dev.jvm.classloader.Child from file:/D:/VCS/Git/dev/dev-jvm/out/production/classes/]
         *  </p>
         *  可以看出即使没有对子类进行初始化，子类还是被加载了
         */
        System.out.println(Child.str);

        // System.out.println("------------------");

        /**
         * 这里主动使用了子类Child中的静态量，则Child会被初始化，
         * 子类被初始化，则父类也会被初始化，父类中的静态代码块也会初始化
         */
        //System.out.println(Child.str2);
    }
}

class Parent {
    public static String str = "hello world";

    static {
        System.out.println("Parent class instance static block!");
    }
}

class Child extends Parent {

    public static String str2 = "child hello world";

    static {
        System.out.println("Child class instance static block!");
    }
}
