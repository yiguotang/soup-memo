package com.soup.memo.common.compare;

import lombok.Data;

/**
 * Compare 测试bean
 *
 * @author zhaoyi
 */
@Data
public class User {

    private String name;

    private String city;

    private Integer age;

    private String compareReason;

    public User(String name, String city, Integer age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }
}
