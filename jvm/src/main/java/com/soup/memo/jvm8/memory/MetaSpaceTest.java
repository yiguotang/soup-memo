package com.soup.memo.jvm8.memory;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author zhaoyi
 * @description 元空间溢出的示例，设置元空间大小： -XX:MaxMetaspaceSize=10m
 *               可以加上 -XX:+TraceClassLoading 进行类加载器加载的类打印在控制台
 *
 * @date 2019-03-24 21:38
 **/
public class MetaSpaceTest {

    public static void main(String[] args) {
        MethodAreaTest.methodAreaTest();
    }
}

@Slf4j
class MethodAreaTest {

    /**
     * 使用cglib，创建class，模拟方法区的溢出
     */
    public static void methodAreaTest() {
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MethodAreaTest.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
            log.info("hello world");
            enhancer.create();
        }
    }
}
