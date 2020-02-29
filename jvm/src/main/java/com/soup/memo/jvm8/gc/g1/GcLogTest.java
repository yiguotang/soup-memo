package com.soup.memo.jvm8.gc.g1;

/**
 * <p>
 *  分析G1的日志输出
 *
 *  jvm启动参数：
 *      -verbose:gc 打印gc日志
 *      -Xms10m
 *      -Xmx10m
 *      -XX:+UseG1GC    使用G1垃圾回收
 *      -XX:+PrintGCDetails
 *      -XX:+PrintGCDateStamps
 *      -XX:MaxGCPauseMillis=200    指定最大停顿时间200毫秒
 * </p>
 *
 * @author zhaoyi
 * @date 2020-02-28 20:44
 * @since 1.0
 */
public class GcLogTest {

    public static void main(String[] args) {
        // 1M 大小
        int size = 1024 * 1024;
        byte[] allocate1 = new byte[size];
        byte[] allocate2 = new byte[size];
        byte[] allocate3 = new byte[size];
        byte[] allocate4 = new byte[size];


        System.out.println("hello world");
    }

}
