package com.soup.memo.kotlin.interfaces;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoyi
 * @date 2020-03-07 18:06
 * @since 1.0
 */
public class A implements AInterface {

    public static final A a = new A();

    @Override
    public void putNumber(int num) {
        System.out.println("int");
    }

    @Override
    public void putNumber(Integer num) {
        System.out.println("Integer");
    }

    public static String format(String string) {
        return string.isEmpty() ? null : string;
    }
}
