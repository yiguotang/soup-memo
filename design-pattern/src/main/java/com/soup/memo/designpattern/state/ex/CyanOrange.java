package com.soup.memo.designpattern.state.ex;

/**
 * 青色橘子
 *
 * @author zhaoyi
 */
public class CyanOrange implements Orange {
    @Override
    public void printColor() {
        System.out.println("My color is Cyan");
    }
}
