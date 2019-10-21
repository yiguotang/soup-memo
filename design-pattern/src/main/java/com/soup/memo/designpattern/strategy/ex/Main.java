package com.soup.memo.designpattern.strategy.ex;

/**
 * main
 *
 * @author zhaoyi
 */
public class Main {

    public static void main(String[] args) {

        Fruit fruit = new Apple();
        new FruitPrice(fruit).printPrice();
    }
}
