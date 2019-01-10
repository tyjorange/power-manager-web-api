package com.im.service;

import com.im.mapper.first.FsuMapper;
import com.im.pojo.first.Fsu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vostor on 2019/1/9.
 */
@Service
public class FsuService {
    @Autowired
    private FsuMapper fsuMapper;

    /**
     * 查询所有fsu列表
     *
     * @return 集中器列表
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Fsu> findAll() {
        return fsuMapper.selectAll();
    }
}
