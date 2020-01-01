package com.memo.springboot.controller;

import com.soup.springboot.config.Config;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * <p>
 *  使用springboot-test进行测试
 * </p>
 *
 * @author zhaoyi
 * @date 2020-01-01 17:58
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Config.class})
public class PersonControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/person")
                .contentType(MediaType.APPLICATION_PROBLEM_JSON_VALUE)
                .accept(MediaType.APPLICATION_PROBLEM_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
