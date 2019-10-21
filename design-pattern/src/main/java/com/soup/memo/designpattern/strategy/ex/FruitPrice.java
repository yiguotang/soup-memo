package com.soup.memo.designpattern.strategy.ex;

/**
 * Fruit Price
 *
 * @author zhaoyi
 */
public class FruitPrice {

    private Fruit fruit;

    public FruitPrice(Fruit fruit) {
        this.fruit = fruit;
    }

    public void printPrice() {
        fruit.price();
    }
}
