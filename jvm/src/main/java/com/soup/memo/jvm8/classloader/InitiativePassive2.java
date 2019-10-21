package com.soup.memo.jvm8.classloader;

/**
 * <p>
 * Description:
 * </p>
 *
 * D:\VCS\Git\dev\dev-jvm\out\production\classes>javap -c com.dev.jvm.classloader.InitiativePassive2
 * Compiled from "InitiativePassive2.java"
 * public class com.dev.jvm.classloader.InitiativePassive2 {
 * public com.dev.jvm.classloader.InitiativePassive2();
 * Code:
 * 0: aload_0
 * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 * 4: return
 *
 * public static void main(java.lang.String[]);
 * Code:
 * 0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 3: ldc           #4                  // String hello world
 * 5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 * 8: return
 * }
 *
 * 助记符：
 * ldc：表示int,float或String类型的常量值从常量池中推送至栈顶
 * bipush：表示将单字节（-128 - 127）的常量值推送到栈顶 ： public static final short s = 7
 * sipush：表示将一个短整型常量值（-32768 - 32767）推送到栈顶： public static final int i = 128
 * iconst_1：表示将int类型1推送至栈顶（iconst_m1, iconst_0 - iconst_5），iconst_ 的形式最多到5： public static final int i = 1
 * anewarray: 表示创建一个引用类型的数组，并将其引用值压入栈顶
 * newarray: 表示创建一个指定的原始类型（int，float，char等）的数组，并将其引用值压入栈顶
 *
 * @author zhaoyi
 * @date 2019-01-26 13:27
 * @since 1.0
 */
public class InitiativePassive2 {

    public static void main(String[] args) {
        /**
         * 类的静态代码块不会被执行
         * 这里将常量存放到了InitiativePassive2类的常量池中，之后InitiativePassive2类与Paren2就没有任何关系了
         * 甚至，可以将Parent2的class文件删除，也不会影响运行结果
         */
        System.out.println(Parent2.i);
    }
}

class Parent2 {
    /**
     * 在编译期间，这个常量会存入到调用这个常量的方法的所在的类的常量池中
     * 即：main()的类InitiativePassive2 的常量池中
     * 本质上，调用类并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化，所以Parent2的静态代码块不会执行
     */
    public final static String str = "hello world";

    public static final int i = -1;

    static {
        System.out.println("Parent2 static block");
    }
}
