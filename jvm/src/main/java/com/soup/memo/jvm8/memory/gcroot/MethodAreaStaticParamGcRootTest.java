package com.soup.memo.jvm8.memory.gcroot;

/**
 * 测试方法区中的静态变量引用的对象作为GCRoots
 *       -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 *
 *  方法区存与堆一样,是各个线程共享的内存区域,用于存放已被虚拟机加载的类信息,常量,静态变量,即时编译器编译后的代码等数据。
 *
 * @author zhaoyi
 * @description 方法区静态变量引用对象的GCRoot
 * @date 2019-03-30 20:02
 **/
public class MethodAreaStaticParamGcRootTest {

    private static int _10MB = 10 * 1024 * 1024;

    private byte[] memory;

    public static MethodAreaStaticParamGcRootTest gcRoot;

    public MethodAreaStaticParamGcRootTest(int size) {
        this.memory = new byte[size];
    }

    public static void main(String[] args) {
        MethodAreaStaticParamGcRootTest root = new MethodAreaStaticParamGcRootTest(4 * _10MB);

        MethodAreaStaticParamGcRootTest.gcRoot = new MethodAreaStaticParamGcRootTest(8 * _10MB);
        root = null;

        // root被置为null，Minor GC后t2之前引用的对象（40M）被完全回收；
        // gcRoot为静态变量，存放于方法区中，引用了对象（80M），在Minor GC后，被转移到老年代中，且在Full GC后，也不会被回收，继续保留在老年代中。
        System.gc();
    }
}
