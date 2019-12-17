package com.soup.memo.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * 打印堆栈调用，发生异常是可以从异常中获取到堆栈调用信息，这里是使用工具类打印无异常时的堆栈调用信息
 *
 * @author zhaoyi
 */
@Slf4j
public class PrintStackInfo {

    public static void main(String[] args) {
        PrintStackInfo stackInfo = new PrintStackInfo();
        stackInfo.method();
    }


    private void method() {
        String method = "method";
        method = methodA();
    }

    private String methodA() {
        String method = "methodA";
        method = methodB();
        return method;
    }

    private String methodB() {
        String method = "methodB";

        // 打印调用到此处的栈调用信息列表
        log.info("方法调用栈信息：{}", ExceptionUtils.getStackTrace(new Throwable("调用出错")));

        return method;
    }
}
