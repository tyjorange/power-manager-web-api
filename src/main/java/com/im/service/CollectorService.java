package com.im.service;

import com.im.mapper.first.CollectorMapper;
import com.im.pojo.first.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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

    /**
     * 根据ID查询集中器信息
     *
     * @param fsuID 集中器ID
     * @return 集中器信息
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Collector> findByFsuID(String fsuID) {
        Example example = new Example(Collector.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fsuid", fsuID);
        return collectorMapper.selectByExample(example);
    }

}
