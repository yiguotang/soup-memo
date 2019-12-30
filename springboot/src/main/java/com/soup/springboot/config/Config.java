package com.soup.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@Slf4j
@Configuration
public class Config {

    /**
     * 生成自定义配置对象的实例对象返回
     *
     * 注解 ConfigurationProperties 的prefix需要都是小写
     *
     * @return MyConfigBean
     */
    @Bean
    @ConfigurationProperties(prefix = "myconfig.configobj", ignoreInvalidFields = true)
    public MyConfigBean myConfigBean() {
        return new MyConfigBean();
    }
}
