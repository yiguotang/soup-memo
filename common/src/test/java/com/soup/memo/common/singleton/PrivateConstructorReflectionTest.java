package com.soup.memo.common.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 使用反射的方式调用单例类 {@link PrivateConstructor} 的私有构造方法
 *
 * @author zhaoyi
 */
@Slf4j
public class PrivateConstructorReflectionTest {

    @Test
    public void invokePrivateConstructor() throws Exception {
        log.info("{}", PrivateConstructor.INSTANCE);

        Class<PrivateConstructor> elvisClass = PrivateConstructor.class;

        Constructor<PrivateConstructor> privateConstructor = elvisClass.getDeclaredConstructor();
        privateConstructor.setAccessible(true);
        PrivateConstructor elvis = privateConstructor.newInstance();

        log.info("{}",elvis);
        Assert.assertNotSame(PrivateConstructor.INSTANCE, elvis);
    }
}
