package com.soup.memo.jvm8.reference;

import java.lang.ref.WeakReference;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoyi
 * @date 2020-02-29 23:41
 * @since 1.0
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        Date date = new Date();
        WeakReference<Date> reference = new WeakReference<>(date);
        System.out.println("立即取出：" + reference.get());
        date = null;
        System.out.println("将强引用置null，再次取出：" + reference.get());

        System.gc();
        System.out.println("执行完gc后，再取出：" + reference.get());
    }
}
