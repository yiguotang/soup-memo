package com.soup.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *  配置类
 * </p>
 *
 * @author zhaoyi
 * @date 2019-12-28 23:09
 * @since 1.0
 */
@Configuration
public class Config {

    /**
     * 生成自定义配置对象的实例对象返回
     *
     * @return MyConfigBean
     */
    @Bean
    public MyConfigBean myConfigBean() {
        return new MyConfigBean();
    }
}
