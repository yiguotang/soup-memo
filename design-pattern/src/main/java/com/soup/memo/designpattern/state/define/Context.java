package com.soup.memo.designpattern.state.define;

/**
 * 环境上下文
 * 定义客户端感兴趣的接口，保留一个具体状态类的实例
 *
 * @author zhaoyi
 */
public class Context {

    private State state;

    /**
     * 设置状态值
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * 执行状态接口的处理方法
     */
    public void request() {
        state.handler();
    }
}
