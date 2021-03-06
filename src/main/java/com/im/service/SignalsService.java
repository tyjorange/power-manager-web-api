package com.im.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.im.bean.viewobject.HisData;
import com.im.mapper.first.SignalsMapper;
import com.im.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    /**
     * @param switchIds
     * @param signalsType
     * @param startTime
     * @param endTime
     * @param page
     * @param limit
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<HisData> findBySignalsTypesAndSwitchs(List<String> switchIds, List<String> signalsType, String startTime, String endTime, Integer page, Integer limit) {
        LocalDateTime t1 = DateUtil.getDateTimeOfTimestamp(Long.valueOf(startTime));
        LocalDateTime t2 = DateUtil.getDateTimeOfTimestamp(Long.valueOf(endTime));

        List<String> pp = new ArrayList<>();
        LocalDateTime temp = t1.plusDays(0);//copy a LocalDateTime object
        while (temp.isBefore(t2)) {
            pp.add("p" + (temp.getDayOfYear()));
            temp = temp.plusDays(1);
        }
        pp.add("p" + t2.getDayOfYear());

        String format1 = dateTimeFormatter.format(t1);
        String format2 = dateTimeFormatter.format(t2);
        // 调用分页插件
        PageHelper.startPage(page, limit);
        PageInfo<HisData> pageInfo = new PageInfo<>(signalsMapper.getSignalsByTimeAndSwitch(switchIds, pp, format1, format2));
        pageInfo.getList().forEach(hisData -> hisData.setDataTime(hisData.getTime().getTime()));
        return pageInfo;
    }

}
