package com.soup.memo.spring.ch1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoyi
 * @description xml的方式注入bean
 * @date 2019-05-05 22:24
 **/
@Slf4j
public class MainAppXml {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean/beans.xml");
        DemoBean obj = (DemoBean) context.getBean("demoBean");
        log.info("xml bean message property: {}", obj.getMessage());
    }
}
