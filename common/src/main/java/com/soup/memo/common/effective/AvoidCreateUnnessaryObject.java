package com.soup.memo.common.effective;

import cn.hutool.core.date.TimeInterval;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 避免创建不必要的对象测试
 *
 * @author zhaoyi
 */
@Slf4j
public class AvoidCreateUnnessaryObject {

    public static void main(String[] args) {
        sum();
    }

    /**
     * 自动装箱带来不必要对象的创建
     */
    private static void sum() {
        TimeInterval timeInterval = new TimeInterval();

        Long sum = 0L;
        timeInterval.start();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        log.info("autoboxing type sum consume: {}s, sum: {}", timeInterval.intervalSecond(), sum);

        long sumV2 = 0L;
        timeInterval.restart();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sumV2 += i;
        }
        log.info("primitive type sum consume: {}ms, sum: {}", timeInterval.intervalMs(), sumV2);
    }
}
