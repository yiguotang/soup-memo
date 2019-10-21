package com.soup.memo.designpattern.state.ex;

/**
 * 使用类
 *
 * @author zhaoyi
 */
public class Main {
    public static void main(String[] args) {
        OrangeManager manager = new OrangeManager();

        Orange orange = new CyanOrange();
        manager.setOrange(orange);

        manager.print();
    }
}
