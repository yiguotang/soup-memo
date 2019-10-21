package com.soup.memo.jvm8.gc;

/**
 * @author zhaoyi
 * @description MaxTenuringThreshold参数
 *              配置jvm启动参数
 *                  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+PrintCommandLineFlags -XX:MaxTenuringThreshold=5 -XX:+PrintTenuringDistribution
 *
 *                  -XX:MaxTenuringThreshold=5，在可以自动调节对象晋升（Promote）到老年代阈值的GC中，设置该阈值的最大值
 *                                              在新生代进行了一次MinorGC后，对象的年龄为1，再进行了一次MinorGC，年龄为2
 *                                              但是不是说这个参数设置了，就必须存活到这个年龄才晋升，jvm可能在2的时候就晋升了，但是肯定不会超过设定的值
 *                                              这个参数的默认值是15，CMS收集器中默认值是6，G1收集器默认为15（jvm中，该数值是由4个bit来表示的，所以最大值是1111，即15）
 *                  -XX:+PrintTenuringDistribution，
 *
 *      经历了多次GC后，存活的对象会在From Surivivor与To Survivor之间来回存放，而这里的一个前提是这两个空间有足够的大小来存放这些数据，
 *      在GC算法中，会计算每个对象年龄的大小，如果达到某个年龄后发现总大小已经大于Survivor空间的50%，那么这时候就需要调整阈值，不能再继续等到15次的GC后才晋升，
 *      因为这样会导致Surivivor不足，所以需要调整阈值（即减小阈值），让这些存活对象尽快完成晋升。
 * @date 2019-04-21 17:49
 **/
public class MaxTenuringThreshold {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        // 构建原生数据类型的字节数组
        byte[] allocate1 = new byte[2 * size];
        byte[] allocate2 = new byte[2 * size];
        byte[] allocate3 = new byte[5 * size];
        byte[] allocate4 = new byte[5 * size];
    }
}
