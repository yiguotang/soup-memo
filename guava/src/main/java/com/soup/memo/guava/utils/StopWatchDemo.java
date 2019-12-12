package com.soup.memo.guava.utils;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  StopWatch : 统计执行时间
 * </p>
 *
 * @author zhaoyi
 * @date 2019-03-28 10:57
 */
@Slf4j
public class StopWatchDemo {


    public static void main(String[] args) throws Exception {
        process(new Random(10).nextInt());
    }

    private static void process(int orderNo) throws InterruptedException {
        log.info("start process the order [{}]", orderNo);
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.MICROSECONDS.sleep(new Random(10).nextInt());
        log.info("the order [{}] processs successful and elapsed [{}] minutes.", orderNo,
                        stopwatch.stop().elapsed(TimeUnit.MINUTES));

    }

}
