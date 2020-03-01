package com.soup.memo.jvm8.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Date;

/**
 * <p>
 *  ReferenceQueue引用队列，其设计目的在于让我们能够知道或识别出垃圾收集器所执行的动作
 * </p>
 *
 * @author zhaoyi
 * @date 2020-02-29 23:39
 * @since 1.0
 */
public class SoftReferenceTest2 {
    public static void main(String[] args) {
        Date date = new Date();
        ReferenceQueue<Date> referenceQueue = new ReferenceQueue<>();
        SoftReference<Date> softReference = new SoftReference<>(date, referenceQueue);
        System.out.println(softReference.get());
    }
}
