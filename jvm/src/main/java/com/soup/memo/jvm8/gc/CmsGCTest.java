package com.soup.memo.jvm8.gc;

/**
 * <p>
 *  CMS垃圾收集器测试
 *  相关JVM启动参数：
 *      -verbose:gc
 *      -Xms20M 最小堆20M
 *      -Xmx20M 最大堆20M
 *      -Xmn10M 新生代10M
 *      -XX:+PrintGCDetails 打印GC日志
 *      -XX:SurvivorRatio=8 Eden、FromSurvivor、ToSurvivor的空间比例是：8:1:1
 *      -XX:+UseConcMarkSweepGC  使用CMS，新生代则默认使用ParNew收集器（通过GC日志可以得知）
 * </p>
 *
 * @author zhaoyi
 * @date 2020-02-15 21:35
 * @since 1.0
 */
public class CmsGCTest {
    public static void main(String[] args) {
        // 1M 大小
        int size = 1024 * 1024;

        // 构建原生数据类型的字节数组

        // 新生代分配4M，Eden空间是8M，足够分配
        byte[] allocate1 = new byte[4 * size];
        System.out.println("111111");

        byte[] allocate2 = new byte[4 * size];
        System.out.println("222222");

        byte[] allocate3 = new byte[4 * size];
        System.out.println("333333");

        byte[] allocate4 = new byte[2 * size];
        System.out.println("444444");

    }
}
