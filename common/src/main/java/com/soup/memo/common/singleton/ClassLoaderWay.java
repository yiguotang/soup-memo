package com.soup.memo.common.singleton;

/**
 * 类加载的方式
 *
 * @author zhaoyi
 */
public class ClassLoaderWay {

    private ClassLoaderWay() {}

    private static class ClassLoaderWayHolder {
        public static ClassLoaderWay instance = new ClassLoaderWay();
    }

    public static ClassLoaderWay getInstance() {
        return ClassLoaderWayHolder.instance;
    }

}
