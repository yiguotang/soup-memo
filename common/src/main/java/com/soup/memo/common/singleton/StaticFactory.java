package com.soup.memo.common.singleton;

/**
 * 单例实现方式二：静态工厂方式的单例
 *
 * @author zhaoyi
 */
public class StaticFactory {
    private static final StaticFactory INSTANCE = new StaticFactory();

    private StaticFactory() {
    }

    public static StaticFactory getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {}
}
