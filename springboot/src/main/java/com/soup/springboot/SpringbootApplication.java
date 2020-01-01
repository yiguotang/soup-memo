package com.soup.springboot;

import com.soup.springboot.echo.DefaultEchoService;
import com.soup.springboot.echo.EchoService;
import com.soup.springboot.echo.EchoWebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * springboot 启动类
 * @author zhaoyi
 */
@Slf4j
@SpringBootApplication
@EnableWebSocket
public class SpringbootApplication implements WebSocketConfigurer {

    public static void main(String[] args) {

        // 打印类加载器
        log.info("加载 SpringbootApplication classLoader 是: {}", SpringbootApplication.class.getClassLoader());

        SpringApplication.run(SpringbootApplication.class, args);

        // 也可以使用下面的方式进行启动
        /*SpringApplication application = new SpringApplication(SpringbootApplication.class);
        // customize application settings here，定制高级配置
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);*/

    }

    @Bean
    public EchoService echoService() {
        return new DefaultEchoService("You said \"%s\"! ");
    }

    @Bean
    public WebSocketHandler echoWebSocketHandler() {
        return new EchoWebSocketHandler(echoService());
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoWebSocketHandler(), "/echo").withSockJS();
    }
}
