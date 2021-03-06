package com.im.service;

import com.im.mapper.first.SwitchMapper;
import com.im.pojo.first.Switch;
import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 断路器管理
 * Created by tss on 2018/11/29.
 */
@Service
public class SwitchService {

    @Autowired
    private SwitchMapper switchMapper;


    /**
     * 条件查询断路器列表
     *
     * @param where 查询条件
     * @return switches 断路器列表
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Switch> querySwitchList(String where) {
        List<Switch> switches = null;
        Example example = new Example(Switch.class);
        Example.Criteria criteria = example.createCriteria();
        if (where != null && !where.isEmpty()) {
            criteria.andCondition(where);
        }
        example.orderBy("addtime").desc();
        switches = switchMapper.selectByExample(example);
        return switches;
    }

    /**
     * 查询所有断路器列表
     *
     * @return 断路器列表
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Switch> findAll() {
        return switchMapper.selectAll();
    }

    /**
     * 根据ID查询断路器信息
     *
     * @param switchID 断路器ID
     * @return 断路器信息
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Switch findByID(String switchID) {
        if (switchID == null || switchID.isEmpty()) {
            return null;
        }
        Switch _switch = switchMapper.selectByPrimaryKey(switchID);
        return _switch;
    }

    /**
     * 查询某集中器下的断路器列表
     *
     * @param collectorID 集中器ID
     * @return 断路器列表
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Switch> findByCollectorID(String collectorID) {
        if (collectorID == null || collectorID.isEmpty()) {
            return null;
        }
        Example example = new Example(Switch.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("collectorid", collectorID);
        List<Switch> switches = switchMapper.selectByExample(example);
        return switches;
    }

    /**
     * 添加断路器信息
     * @param _switch
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public ServerResponse saveSwitch(Switch _switch) {
        int insert = switchMapper.insert(_switch);
        if (insert == 0) {
            return ServerResponse.success(ResponseCode.ADD_UPDATE_FAILED);
        }
        return ServerResponse.success(ResponseCode.ADD_UPDATE_SUCCESS, _switch);
    }

    /**
     * 修改断路器信息
     * @param _switch
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public ServerResponse updateSwitch(Switch _switch) {
        int update = switchMapper.updateByPrimaryKeySelective(_switch);
        if (update == 0) {
            return ServerResponse.success(ResponseCode.ADD_UPDATE_FAILED);
        }
        return ServerResponse.success(ResponseCode.ADD_UPDATE_SUCCESS, _switch);
    }

    /**
     * 删除断路器信息
     * @param switchID
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public ServerResponse deleteSwitch(String switchID) {
        int i = switchMapper.deleteByPrimaryKey(switchID);
        if (i == 0) {
            return ServerResponse.success(ResponseCode.DEL_FAILED);
        }
        return ServerResponse.success(ResponseCode.DEL_SUCCESS);
    }

}
