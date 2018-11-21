package com.im.service;

import com.im.mapper.DogsMapper;
import com.im.pojo.Dogs;
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
public class DogServiceTest {
    @Autowired
    private DogsMapper mapper;

    @Test
    public void testSaveDog() throws Exception {
        Dogs d = new Dogs();
        d.setDogId(1);
        d.setDogName("test");
        d.setDogAge(17);
        int insert = mapper.insert(d);
        assertEquals(insert, 1);
    }

    @Test
    public void testUpdateDog() throws Exception {
        Dogs d = new Dogs();
        d.setDogId(3);
        d.setDogName("test");
        d.setDogAge(19);
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