package com.im.service;

import com.im.bean.HisData;
import com.im.mapper.first.CollectorMapper;
import com.im.mapper.first.SignalsMapper;
import com.im.mapper.first.SwitchMapper;
import com.im.pojo.first.Switch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 历史信号表
 * Created by vostor on 2019/1/14.
 */
@Service
public class SignalsService {
    @Autowired
    private SignalsMapper signalsMapper;
    @Autowired
    private SwitchMapper switchMapper;
    @Autowired
    private CollectorMapper collectorMapper;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * @param switchIds
     * @param signalsType
     * @param startTime
     * @param endTime
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<HisData> findBySignalsTypesAndSwitchs(List<String> switchIds, List<String> signalsType, String startTime, String endTime) throws ParseException {
        List<HisData> res = new ArrayList<>();
        String format1 = sdf.format(Long.valueOf(startTime));
        String format2 = sdf.format(Long.valueOf(endTime));
        switchIds.forEach(sw -> signalsMapper.getSignalsByTimeAndId(sw, format1, format2).forEach(hisData -> {
                    Switch aSwitch = switchMapper.selectByPrimaryKey(sw);
                    hisData.setSwitchName(aSwitch.getName());
                    hisData.setCollectorName(collectorMapper.selectByPrimaryKey(aSwitch.getCollectorid()).getName());
                    hisData.setDataTime(hisData.getTime().getTime());
                    res.add(hisData);
                })
        );
        return res;
    }
}
