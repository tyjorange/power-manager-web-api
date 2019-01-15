package com.im.service;

import com.im.bean.HisData;
import com.im.mapper.first.CollectorMapper;
import com.im.mapper.first.SignalsMapper;
import com.im.mapper.first.SignalstypeMapper;
import com.im.mapper.first.SwitchMapper;
import com.im.pojo.first.Signals;
import com.im.pojo.first.Signalstype;
import com.im.pojo.first.Switch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by vostor on 2019/1/14.
 */
@Service
public class SignalsService {
    @Autowired
    private SignalsMapper signalsNewMapper;
    @Autowired
    private SignalstypeMapper signalstypeMapper;
    @Autowired
    private SwitchMapper switchMapper;
    @Autowired
    private CollectorMapper collectorMapper;

    /**
     * @param switchIds
     * @param signalsType
     * @param startTime
     * @param endTime
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<HisData> findBySignalsTypesAndSwitchs(List<String> switchIds, List<String> signalsType, Long startTime, Long endTime) {
        List<HisData> res = new ArrayList<>();
        switchIds.forEach(switchId -> signalsType.forEach(signalsTypeId -> {
            Example example = new Example(Signals.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("switchid", switchId)
                    .andEqualTo("signalstypeid", signalsTypeId)
                    .andBetween("time", new Timestamp(startTime), new Timestamp(endTime));
            example.orderBy("time").desc();
            final HisData[] hisData = new HisData[1];
            final long[] s_time = new long[1];
            signalsNewMapper.selectByExample(example).forEach(signalsHis -> {
                if (s_time[0] != signalsHis.getTime().getTime()) {
                    hisData[0] = new HisData();
                }
                Switch aSwitch = switchMapper.selectByPrimaryKey(switchId);
                hisData[0].setSwitchName(aSwitch.getName());
                hisData[0].setCollectorName(collectorMapper.selectByPrimaryKey(aSwitch.getCollectorid()).getName());
                Signalstype signalstype = signalstypeMapper.selectByPrimaryKey(signalsHis.getSignalstypeid());
                hisData[0].setSignalsTypeName(signalstype.getSignalstypeid());
                hisData[0].setWgdl(Objects.equals(signalstype.getSignalstypeid(), "wgdl") ? signalsHis.getValue() : null);
                hisData[0].setYgdl(Objects.equals(signalstype.getSignalstypeid(), "ygdl") ? signalsHis.getValue() : null);
                hisData[0].setWggl(Objects.equals(signalstype.getSignalstypeid(), "wggl") ? signalsHis.getValue() : null);
                hisData[0].setYggl(Objects.equals(signalstype.getSignalstypeid(), "yggl") ? signalsHis.getValue() : null);
                hisData[0].setGlys(Objects.equals(signalstype.getSignalstypeid(), "glys") ? signalsHis.getValue() : null);
                hisData[0].setDl(Objects.equals(signalstype.getSignalstypeid(), "dl") ? signalsHis.getValue() : null);
                hisData[0].setDy(Objects.equals(signalstype.getSignalstypeid(), "dy") ? signalsHis.getValue() : null);
                hisData[0].setPl(Objects.equals(signalstype.getSignalstypeid(), "pl") ? signalsHis.getValue() : null);
                hisData[0].setWd(Objects.equals(signalstype.getSignalstypeid(), "wd") ? signalsHis.getValue() : null);
                hisData[0].setDataTime(String.valueOf(signalsHis.getTime().getTime()));
                res.add(hisData[0]);
                s_time[0] = signalsHis.getTime().getTime();
            });
        }));
        return res;
    }
}
