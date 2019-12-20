package com.soup.memo.jvm8.oom;

import lombok.extern.slf4j.Slf4j;

/**
 * 栈溢出<br/>
 * 配置的参数：<br/>
 *  -Xss128k
 *
 * @author zhaoyi
 */
@Slf4j
public class StackSOM {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        StackSOM stackSOM = new StackSOM();
        try {
            stackSOM.stackLeak();
        } catch (Throwable th) {
            log.error("stack length: {}", stackSOM.stackLength);
            throw th;
        }
    }
}
