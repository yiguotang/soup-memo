package com.soup.memo.designpattern.strategy.ex;

/**
 * 苹果价格
 *
 * @author zhaoyi
 */
public class Apple implements Fruit {
    @Override
    public void price() {
        System.out.println("apple's price");
    }
}
