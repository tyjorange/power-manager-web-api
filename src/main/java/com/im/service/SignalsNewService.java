package com.im.service;

import com.im.bean.RealData;
import com.im.mapper.first.CollectorMapper;
import com.im.mapper.first.SignalsNewMapper;
import com.im.mapper.first.SignalstypeMapper;
import com.im.mapper.first.SwitchMapper;
import com.im.pojo.first.SignalsNew;
import com.im.pojo.first.Signalstype;
import com.im.pojo.first.Switch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 最新信号值查询
 * Created by vostor on 2019/1/10.
 */
@Service
public class SignalsNewService {
    @Autowired
    private SignalsNewMapper signalsNewMapper;
    @Autowired
    private SignalstypeMapper signalstypeMapper;
    @Autowired
    private SwitchMapper switchMapper;
    @Autowired
    private CollectorMapper collectorMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<RealData> findBySignalsTypesAndSwitchs(List<String> switchs, List<String> signalsTypes) {
        List<RealData> res = new ArrayList<>();
        switchs.forEach(switchid -> signalsTypes.forEach(signalstypeid -> {
            Example example = new Example(SignalsNew.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("switchid", switchid)
                    .andEqualTo("signalstypeid", signalstypeid);
            signalsNewMapper.selectByExample(example).forEach(signalsNew -> {
                RealData realData = new RealData();
                Switch aSwitch = switchMapper.selectByPrimaryKey(switchid);
                realData.setSwitchName(aSwitch.getName());
                realData.setCollectorName(collectorMapper.selectByPrimaryKey(aSwitch.getCollectorid()).getName());
                Signalstype signalstype = signalstypeMapper.selectByPrimaryKey(signalsNew.getSignalstypeid());
                realData.setSignalsTypeName(signalstype.getTypename());
                realData.setDataValue(signalsNew.getValue().toString());
                realData.setDataUnit(signalstype.getUnit());
                realData.setDataTime(String.valueOf(signalsNew.getTime().getTime()));
                res.add(realData);
            });
        }));
        return res;
    }
}
