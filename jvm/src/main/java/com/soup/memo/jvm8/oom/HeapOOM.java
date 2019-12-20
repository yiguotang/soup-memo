package com.soup.memo.jvm8.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出 <br/>
 * 配置的参数：<br/>
 *  -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author zhaoyi
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject {}
}
