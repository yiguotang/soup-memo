package com.soup.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 启动类
 * @author zhaoyi
 */
@Slf4j
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {

        // 打印类加载器
        log.info("加载 SpringbootApplication classLoader 是: {}", SpringbootApplication.class.getClassLoader());

        SpringApplication.run(SpringbootApplication.class, args);
    }

}
