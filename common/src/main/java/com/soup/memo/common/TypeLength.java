package com.soup.memo.common;

/**
 * 基本类型的长度
 *
 * @author zhaoyi
 */
public class TypeLength {

    public static void main(String[] args) {
        // byte
        System.out.println("----- byte -----");
        System.out.println("二进制位：" + Byte.SIZE + ", 字节大小：" + Byte.SIZE / 8);
        System.out.println("最大值：" + Byte.MAX_VALUE);
        System.out.println("最小值：" + Byte.MIN_VALUE);

        System.out.println();
        System.out.println("----- short -----");
        System.out.println("二进制位：" + Short.SIZE + ", 字节大小：" + Short.SIZE / 8);
        System.out.println("最大值：" + Short.MAX_VALUE);
        System.out.println("最小值：" + Short.MIN_VALUE);

        System.out.println();
        System.out.println("----- int -----");
        System.out.println("二进制位：" + Integer.SIZE + ", 字节大小：" + Integer.SIZE / 8);
        System.out.println("最大值：" + Integer.MAX_VALUE);
        System.out.println("最小值：" + Integer.MIN_VALUE);

        System.out.println();
        System.out.println("----- long -----");
        System.out.println("二进制位：" + Long.SIZE + ", 字节大小：" + Long.SIZE / 8);
        System.out.println("最大值：" + Long.MAX_VALUE);
        System.out.println("最小值：" + Long.MIN_VALUE);

        System.out.println();
        System.out.println("----- float -----");
        System.out.println("二进制位：" + Float.SIZE + ", 字节大小：" + Float.SIZE / 8);
        System.out.println("最大值：" + Float.MAX_VALUE);
        System.out.println("最小值：" + Float.MIN_VALUE);

        System.out.println();
        System.out.println("----- double -----");
        System.out.println("二进制位：" + Double.SIZE + ", 字节大小：" + Double.SIZE / 8);
        System.out.println("最大值：" + Double.MAX_VALUE);
        System.out.println("最小值：" + Double.MIN_VALUE);

        System.out.println();
        System.out.println("----- char -----");
        System.out.println("二进制位：" + Character.SIZE + ", 字节大小：" + Character.SIZE / 8);
        System.out.println("最大值：" + Character.MAX_VALUE);
        System.out.println("最小值：" + Character.MIN_VALUE);

    }

}
