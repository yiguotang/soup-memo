package com.soup.memo.jvm8.gc;

/**
 * @author zhaoyi
 * @description jvm启动参数
 *      java -XX:+PrintCommandLineFlags -version，表示输出
 *
 *      执行jvm参数
 *      -verbose:gc
 *      -Xms20M
 *      -Xmx20M
 *      -Xmn10M
 *      -XX:+PrintGCDetails
 *      -XX:SurvivorRatio=8
 *      -XX:PretenureSizeThreadhold=4194304，当在新生代创建的一个对象的大小超过这个指定的字节大小，直接在老年代创建
 *                                           但是创建一个对象大于这个值但是小于新生代的大小，发现老年代的使用大小是0，说明这个参数没有起到效果
 *                                           因为默认的启动参数配置了并行的GC收集器，这个参数只能在并行GC收集器才能生效
 *                                           所以需要加上下面的这个参数
 *                                           但是创建一个对象大于这个值并且大于新生代的大小，不需要下面的参数也是可以生效的
 *      -XX:+UseSerialGC
 * @date 2019-04-20 21:18
 **/
public class PretenureSizeThreadhold {

    public static void main(String[] args) throws InterruptedException {
        int size = 1024 * 1024;

        // 创建一个对象大于PretenureSizeThreadhold但是小于新生代的大小
        byte[] alloc = new byte[5 * size];

        // 但是创建一个对象大于PretenureSizeThreadhold并且大于新生代的大小
        // byte[] alloc2 = new byte[8 * size];


        // 可以通过一些工具查看，如jvisualvm，jmc
        Thread.sleep(1000000000);
    }
}
