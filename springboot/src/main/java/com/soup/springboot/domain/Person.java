package com.soup.springboot.domain;

import lombok.Data;

import java.util.Date;

/**
 * 测试Domain
 *
 * @author zhaoyi
 */
@Data
public class Person {

    private int age;

    private String name;

    private Date birthday;
}
