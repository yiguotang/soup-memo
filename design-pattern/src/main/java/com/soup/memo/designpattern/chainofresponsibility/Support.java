package com.soup.memo.designpattern.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 责任链模式
 * Support 抽象类核心方法support，如果能解决就解决，不能解决交给下一级
 *
 * @author zhaoyi
 */
@Slf4j
public abstract class Support {
    private String name;

    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    /**
     * Handler处理者
     * 处理方法：如果本身无法处理，则交给下级去处理，如果下级不存在则报无法处理
     *
     * @param trouble 待处理的事件
     */
    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (null != next) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    /**
     * 处理事件的方法
     *
     * @param trouble 待处理的事件
     * @return 处理结果
     */
    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        log.info("{} was resolved by {}.", trouble, this);
    }

    protected void fail(Trouble trouble) {
        log.info("{} cannot be resolved.", trouble);
    }

    @Override
    public String toString() {
        return "[" + this.name + "]";
    }
}
