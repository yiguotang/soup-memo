package com.soup.memo.jvm8.gc;

import lombok.extern.slf4j.Slf4j;

/**
 * 对象如果不存在GC Roots的引用链，也不会立马被回收，下面的代码演示了对象“自救”的过程
 * 1. 对象可以在被GC的时候进行自救
 * 2. 这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被调用一次
 *
 * @author zhaoyi
 */
@Slf4j
public class FinalizeEscapeGC {

    private static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        log.info("yes! I am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        log.info("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // finalize()方法的优先级很低，暂停0.5秒执行
        Thread.sleep(500);
        if (null != SAVE_HOOK) {
            SAVE_HOOK.isAlive();
        } else {
            log.info("no, i am dead!");
        }

        // 对象第二次拯救自己失败
        SAVE_HOOK = null;
        System.gc();

        // finalize()方法的优先级很低，暂停0.5秒执行
        Thread.sleep(500);
        if (null != SAVE_HOOK) {
            SAVE_HOOK.isAlive();
        } else {
            log.info("no, i am dead!");
        }

    }
}
