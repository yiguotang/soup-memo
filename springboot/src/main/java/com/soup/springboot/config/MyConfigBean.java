package com.soup.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * <p>
 *  自定义配置对象
 * </p>
 *
 * @author zhaoyi
 * @date 2019-12-28 23:07
 * @since 1.0
 */
@Data
public class MyConfigBean {

    @Value("${myConfig.configObj.name}")
    private String name;

    @Value("${myConfig.configObj.age}")
    private int age;

}
