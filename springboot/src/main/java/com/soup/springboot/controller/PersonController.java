package com.soup.springboot.controller;

import com.soup.springboot.config.MyConfigBean;
import com.soup.springboot.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试Persion api
 *
 * @author zhaoyi
 */
@Slf4j
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
public class PersonController {

    @Autowired
    private MyConfigBean myConfigBean;

    @GetMapping("/person")
    public Object person() {
        Person person = new Person();
        person.setAge(23);
        person.setName("zhangsan");
        person.setBirthday(new Date());

        log.info("========分割线========");

        log.info("{}", myConfigBean);

        return person;
    }
}
