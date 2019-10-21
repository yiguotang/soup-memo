package com.soup.memo.designpattern.state.ex;

/**
 * 红色橘子
 *
 * @author zhaoyi
 */
public class RegOrange implements Orange {
    @Override
    public void printColor() {
        System.out.println("My color is Red");
    }
}
