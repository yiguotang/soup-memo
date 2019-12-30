package com.soup.springboot.config;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  从配置文件中读取配置信息，封装成自定义配置对象
 * </p>
 *
 * @author zhaoyi
 * @date 2019-12-28 23:07
 * @since 1.0
 */
@Data
public class MyConfigBean {

    private String name;

    private int age;

    private List<String> usedName;

    private Map<String, String> map;

    private List<Map<String, String>> keyVals;
}
