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
public class ProductBean {

    private String name;

    private Double amount;

    private String description;

    private Integer number;

    public ProductBean(String name, Double amount, String description, Integer number) {
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.number = number;
    }
}
