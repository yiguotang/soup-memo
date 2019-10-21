package com.soup.memo.jvm8.classloader;

/**
 * 对于数组实例来说，其类型是由jvm在运行期动态生成的，表示为[Lcom.dev.jvm.classloader.Parent4这种形式
 * 动态生成的类型，父类就是Object
 * 对于数组来说，JavaDoc经常构成数组的元素为Component，实际上就是将数组降低一个维度后类型
 *
 * @author zhaoyi
 * @date 2019-01-27 10:55
 * @since 1.0
 */
public class InitiativePassive4 {

    public static void main(String[] args) {
        /**
         * 会执行Parent4中的静态代码块，这是七种主动使用类的情况：创建类的实例
         */
        Parent4 parent = new Parent4();
        /**
         * 不会再执行Parent4的静态代码块，类已经在上面初始化过了，初始化只在首次初始化
         */
        Parent4 parent2 = new Parent4();

        System.out.println("-------分割线-----");

        /**
         * 没有执行静态代码块，没有导致类的初始化
         * [Lcom.dev.jvm.classloader.Parent4; 是数组类型，运行期生成出来的
         * 反编译后的助记符是anewarray，引用类型的数组
         */
        Parent4[] parents = new Parent4[1];
        System.out.println(parents.getClass());
        System.out.println(parents.getClass().getSuperclass());

        System.out.println("-------分割线-----");

        Parent4[][] parents2 = new Parent4[1][2];
        System.out.println(parents2.getClass());

        System.out.println("-------分割线-----");

        // 原生类型的数组，反编译后的助记符是：newarray，原生类型
        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
    }
}

class Parent4 {
    static {
        System.out.println("Parent4 static block!");
    }
}
