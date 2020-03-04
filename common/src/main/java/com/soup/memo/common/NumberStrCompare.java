package com.soup.memo.common;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoyi
 * @date 2020-02-18 14:28
 * @since 1.0
 */
public class NumberStrCompare {

    public static void main(String[] args) {
        String str1 = "2.3";
        String str2 = "2.30";
        BigDecimal d1 = new BigDecimal(str1);
        BigDecimal d2 = new BigDecimal(str2);
        System.out.println(d1.compareTo(d2));

        System.out.println("------------------");

        String num = "0";
        BigDecimal decimal = new BigDecimal(num);
        System.out.println(decimal);
    }
}
