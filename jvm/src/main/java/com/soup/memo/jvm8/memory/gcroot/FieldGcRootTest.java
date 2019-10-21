package com.soup.memo.jvm8.memory.gcroot;

/**
 * 测试成员变量是否可以作为GCroot
 *  -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 *
 * @author zhaoyi
 * @description 成员变量是否可以作为GCRoot
 * @date 2019-03-30 20:23
 **/
public class FieldGcRootTest {
    private static int _10MB = 10 * 1024 * 1024;
    private FieldGcRootTest gcRoot;
    private byte[] memory;

    public FieldGcRootTest(int size) {
        memory = new byte[size];
    }

    public static void main(String[] args) {
        FieldGcRootTest root = new FieldGcRootTest(4 * _10MB);
        root.gcRoot = new FieldGcRootTest(8 * _10MB);
        root = null;

        // root被置为null，Minor GC后t4之前引用的对象（40M）被完全回收；
        // gcRoot为成员变量，也叫实例变量，不同于类变量（静态变量），
        // 前面讲到类变量是存储在方法区中，而成员变量是存储在堆内存的对象中的，和对象共存亡，
        // 所以是不能作为GC Roots的，从日志中也可看出t在MinorGC后，跟随root一起被完全回收。不再占用任何空间。
        System.gc();
    }
}
