package com.soup.memo.jvm8.memory.gcroot;

/**
 * 测试方法区常量引用对象作为GCRoots
 *       -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 *
 *  注意：gcRoot修饰符如果只是final会被回收，static final不会被回收，所以static final 才是常量的正确写法
 *
 * @author zhaoyi
 * @description 测试方法区常量引用对象作为GCRoots
 * @date 2019-03-30 20:02
 **/
public class MethodAreaFinalParamGcRootTest {

    private static int _10MB = 10 * 1024 * 1024;

    public static final MethodAreaFinalParamGcRootTest gcRoot = new MethodAreaFinalParamGcRootTest(8 * _10MB);

    private byte[] memory;

    public MethodAreaFinalParamGcRootTest(int size) {
        this.memory = new byte[size];
    }

    public static void main(String[] args) {
        MethodAreaFinalParamGcRootTest root = new MethodAreaFinalParamGcRootTest(4 * _10MB);
        root = null;

        // root被置为null，Minor GC后root之前引用的对象（40M）被完全回收；
        // gcRoot为常量，存放于方法区中，引用了对象（80M），在Minor GC后，被转移到老年代中，且在Full GC后，也不会被回收，继续保留在老年代中。
        System.gc();
    }
}
