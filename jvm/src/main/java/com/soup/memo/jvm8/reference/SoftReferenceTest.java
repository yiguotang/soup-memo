package com.soup.memo.jvm8.reference;

import java.lang.ref.SoftReference;
import java.util.Date;

/**
 * <p>
 *  软引用测试
 * </p>
 *
 * @author zhaoyi
 * @date 2020-02-29 22:22
 * @since 1.0
 */
public class SoftReferenceTest {

    public static void main(String[] args) {
        Date date = new Date();
        SoftReference<Date> reference = new SoftReference<>(date);

        Date date1 = reference.get();
        // 这种从软引用的方式是不恰当的，
        // System.out.println(date1);

        // 正确使用软引用的方式
        if (null != date1) {
            System.out.println(date1);
        } else {
            System.out.println("软引用对象已被gc回收");
        }
    }
}
