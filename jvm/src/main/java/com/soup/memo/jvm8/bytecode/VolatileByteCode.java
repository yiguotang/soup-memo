package com.soup.memo.jvm8.bytecode;

/**
 * 查看 volatile 关键字的字节码信息: ACC_VOLATILE
 *
 * @author zhaoyi
 */
public class VolatileByteCode {

    static volatile int i;

    public static void main(String[] args){
        i = 10;
    }

}