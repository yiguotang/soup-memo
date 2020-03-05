package com.soup.memo.thread;

import org.openjdk.jol.info.ClassLayout;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoyi
 * @date 2020-03-05 20:34
 * @since 1.0
 */
public class ObjLayout {
    public static void main(String[] args) {
        Object obj = new Object();

        System.out.println("--------new Object()的内存布局---------");

        /**
         * 打印对象布局
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        System.out.println("--------当调用hashcode的对象布局---------");
        // 当调用hashcode的对象
        obj.hashCode();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        System.out.println("--------加synchronized后的对象内存布局---------");

        /**
         * 加synchronized后的对象内存布局
         */
        synchronized (obj) {
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }

    }
}
