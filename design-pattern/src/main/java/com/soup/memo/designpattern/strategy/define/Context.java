package com.soup.memo.designpattern.strategy.define;

/**
 * 上下文环境
 *
 * @author zhaoyi
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.strategyInterface();
    }

}
