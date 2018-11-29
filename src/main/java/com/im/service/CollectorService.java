package com.im.service;

import com.im.mapper.CollectorMapper;
import com.im.pojo.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 集中器管理
 * Created by tss on 2018/11/29.
 */
@Service
public class CollectorService {

    @Autowired
    private CollectorMapper collectorMapper;

    /**
     * 查询所有集中器列表
     *
     * @return 集中器列表
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Collector> findAll() {
        return collectorMapper.selectAll();
    }

    /**
     * 根据ID查询集中器信息
     *
     * @param collectorID 集中器ID
     * @return 集中器信息
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Collector findByID(String collectorID) {
        return collectorMapper.selectByPrimaryKey(collectorID);
    }

}
