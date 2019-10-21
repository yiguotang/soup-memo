package com.soup.memo.jvm8.classloader;

import java.util.Random;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-28 13:05
 */
public class ClassLoader2 {

    public static void main(String[] args) {
        /**
         * FinalTest 类中的静态代码块不会输出，
         * 虽然直接使用了FinalTest类，但是静态常量r是final的，同时r的值在编译期间是可以确定值的，
         * 这个r值就会在编译期间被存入调用类（ClassLoader2）的常量池中，
         * 这样在编译之后，ClassLoader2类与FinalTest没有任何关联关系了
         */
        // System.out.println(FinalTest.r);

        /**
         * FinalTest 类中的静态代码块会输出，虽然x是final修饰的，但是x的值不是在编译期间就可以确定值的，FinalTest会被初始化，导致FinalTest类的静态代码块的内容被执行
         */
        System.out.println(FinalTest.x);
    }



}

class FinalTest {

    public static final int r = 3;

    public static final int x = new Random().nextInt(2);

    static {
        System.out.println("FinalTest static block ");
    }
}
