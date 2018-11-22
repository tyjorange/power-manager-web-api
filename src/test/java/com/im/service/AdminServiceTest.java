package com.im.service;

import com.im.mapper.AdminMapper;
import com.im.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by vostor on 2018/10/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class AdminServiceTest {
    @Autowired
    private AdminMapper mapper;

    @Test
    public void testSaveDog() throws Exception {
        Admin d = new Admin();
        d.setId("a12");
        d.setUsername("test");
        int insert = mapper.insert(d);
        assertEquals(insert, 1);
    }

    @Test
    public void testUpdateDog() throws Exception {
        Admin d = new Admin();
        d.setId("ss");
        d.setUsername("test");
        d.setPassword("s");
        int i = mapper.updateByPrimaryKeySelective(d);
        assertEquals(i, 1);
    }

    @Test
    public void testDeleteDog() throws Exception {

    }

    @Test
    public void testQueryDogById() throws Exception {

    }

    @Test
    public void testQueryDogList() throws Exception {

    }

    @Test
    public void testJudgeAge() throws Exception {

    }
}