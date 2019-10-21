package com.soup.memo.jvm8.gc;

/**
 * 配置jvm启动参数
 *      -verbose:gc
 *      -Xmx200M
 *      -Xmn50M
 *      -XX:TargetSurvivorRation=60, Survivor空间中已存活的空间占据60%，将会重新计算存活对象晋升的阈值
 *      -XX:+PrintTenuringDistribution, 打印对象在survivor空间的存活的年龄的情况
 *      -XX:+PrintGCDetails
 *      -XX:+PrintGCDataStamps
 *      -XX:+UseConcMarkSweepGC，指定老年代的垃圾收集器，CMS
 *      -XX:+UseParNewGC，指定新生代的垃圾收集器
 *      -XX:MaxTenuringThreshold=3
 * @author zhaoyi
 * @description MaxTenuringThreshold demo
 * @date 2019-05-02 11:35
 **/
public class MaxTenuringThresholdTest {

    public static void main(String[] args) throws InterruptedException {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512 * 1024];

        myGc();
        Thread.sleep(1000);

        System.out.println("======111=======");

        myGc();
        Thread.sleep(1000);

        System.out.println("======222=======");

        myGc();
        Thread.sleep(1000);

        System.out.println("======333=======");

        myGc();
        Thread.sleep(1000);

        System.out.println("======444=======");

        byte[] byte_3 = new byte[512 * 1024];
        byte[] byte_4 = new byte[512 * 1024];
        byte[] byte_5 = new byte[512 * 1024];

        myGc();
        Thread.sleep(1000);

        System.out.println("======555=======");

        myGc();
        Thread.sleep(1000);
        System.out.println("======6666=======");

        System.out.println("hello");
    }

    /**
     * 产生大量的字节数组对象
     * 当方法退出时，创建的字节数组对象就会被GC回收
     */
    private static void myGc() {
        for (int i = 0; i < 40; i++) {
            byte[] byteArray = new byte[1024 * 1024];
        }
    }
}
