package com.soup.springboot.controller;

/**
 * <p>
 *  jsp整合测试
 * </p>
 *
 * @author zhaoyi
 * @date 2020-01-01 16:59
 * @since 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class JspController {

    @GetMapping("/jsp")
    public String jsp(Map<String, Object> model) {
        model.put("date", new Date());
        model.put("message", "hello jsp");

        return "result";
    }

    @RequestMapping("/jspError")
    public String jspError(Map<String, Object> model) {
        throw new RuntimeException("jspError");
    }
}
