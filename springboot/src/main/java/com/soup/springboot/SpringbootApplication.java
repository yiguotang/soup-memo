package com.soup.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 启动类
 * @author zhaoyi
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);

        // 也可以使用下面的方式进行启动
        /*SpringApplication application = new SpringApplication(SpringbootApplication.class);
        // customize application settings here，定制高级配置
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);*/

    }

}
