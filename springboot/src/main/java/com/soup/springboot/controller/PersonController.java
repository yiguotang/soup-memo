package com.soup.springboot.controller;

import com.soup.springboot.domain.Person;
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
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
public class PersonController {

    @GetMapping("/person")
    public Object person() {
        Person person = new Person();
        person.setAge(23);
        person.setName("zhangsan");
        person.setBirthday(new Date());

        return person;
    }
}
