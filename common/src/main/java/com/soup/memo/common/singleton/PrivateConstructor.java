package com.soup.memo.common.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 单例实现方式一：静态实例，私有构造方法
 *
 * @author zhaoyi
 */
@Slf4j
public class PrivateConstructor {

    public static final PrivateConstructor INSTANCE = new PrivateConstructor();

    /**
     * 私有构造可以通过反射方式来构建，需要在构造方法里进行处理，当创建第二个实例对象，抛出异常
     */
    private PrivateConstructor() {
        if (!this.equals(INSTANCE)) {
            // throw new IllegalAccessException("");
            log.error("IllegalAccess");
        }
    }

    public void leaveTheBuilding() {}
}
