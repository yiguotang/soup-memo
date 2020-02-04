package com.soup.memo.common;

import cn.hutool.core.lang.Assert;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 自动拆装箱
 *
 * @author zhaoyi
 */
@Slf4j
public class Autoboxing {

    public static void main(String[] args) {
        // 自动拆装箱带来的值比骄判断
        int i = 0;
        Box box = new Box();
        // box对象的成员变量flag为Integer类型，进行比较会进行拆箱操作，但是未赋初始值，拆箱操作会抛出NullPointerException
        Assert.isFalse(i == box.getFlag());
        log.info("{}");

        // Integer的缓存
        Integer cache1 = 128;
        Integer cache2 = 128;
        log.info("{}", cache1 == cache2);

    }

    @Data
    static class Box {
        private Integer flag;
    }

}
