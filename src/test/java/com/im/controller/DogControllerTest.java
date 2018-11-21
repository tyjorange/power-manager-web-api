package com.im.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.Assert.*;

/**
 * Created by vostor on 2018/10/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DogControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testQueryDog() throws Exception {
        //API接口调用测试
//        MultiValueMap<String, String> stringMultiValueMap = new LinkedMultiValueMap<>();
//        stringMultiValueMap.add("page", "1");
//        stringMultiValueMap.add("pageSize", "1");
//        stringMultiValueMap.add("dogName", "f");
//        mvc.perform(MockMvcRequestBuilders.get("/query_dog").params(stringMultiValueMap))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("{\"code\":0,\"msg\":\"查询成功\",\"data\":[{\"dogId\":25,\"dogAge\":18,\"dogName\":\"aaf\",\"dogDesc\":null}],\"total\":9}"));
    }

}