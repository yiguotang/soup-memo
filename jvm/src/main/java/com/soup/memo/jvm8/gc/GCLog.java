package com.soup.memo.jvm8.gc;

/**
 * <p>
 * Description:
 *  添加jvm启动参数
 *      -verbose:gc, 表示输出详细的垃圾回收的日志
 *      -Xms20M，堆初始大小
 *      -Xmx20M，堆的最大大小，通常与初始大小设置成一样，防止出现jvm内存的抖动情况
 *      -Xmn10M，表示堆空间中，指定新生代大小为10M
 *      -XX:+PrintGCDetails，表示打印GC的详情
 *      -XX:SurvivorRatio=8，表示Eden空间与Survivor空间的比例是8:1，
 *                          由于指定了新生代的空间是10M，所以这里的Eden空间是8M，2个Survivor空间分别占用1M大小
 * </p>
 *
 * @author zhaoyi
 * @date 2019-04-18 13:08
 */
public class GCLog {
    public static void main(String[] args) {
        // 1M 大小
        int size = 1024 * 1024;

        // 构建原生数据类型的字节数组
        byte[] allocate1 = new byte[2 * size];
        byte[] allocate2 = new byte[2 * size];
        byte[] allocate3 = new byte[3 * size];
        byte[] allocate4 = new byte[3 * size];

        System.out.println("hello world");
    }
}
