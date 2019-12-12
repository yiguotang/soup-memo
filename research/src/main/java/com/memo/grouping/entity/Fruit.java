package com.memo.grouping.entity;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class Fruit {

    private String name;
    private Integer price;

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return java.util.Objects.equals(name, fruit.name) &&
                java.util.Objects.equals(price, fruit.price);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, price);
    }
}
