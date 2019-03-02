package com.im.service;

import com.im.bean.viewobject.dashboard.CalendarVar;
import com.im.mapper.first.SignalsMapper;
import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.resp.RespResultUtil;
import com.im.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by admin on 2019/1/27.
 */
@Service
public class DashBoardService {
    @Autowired
    private SignalsMapper signalsMapper;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static String HHMMSS_START = " 00:00:00";
    private final static String HHMMSS_END = " 23:59:59";

    /**
     * 日历方式查询用电量
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public RespResult getCalendarData(String time) {
        LocalDateTime t1 = DateUtil.getDateTimeOfTimestamp(Long.valueOf(time));
        String format1 = dateTimeFormatter.format(t1);
        Double dayVar = signalsMapper.getCalendarVar(format1 + HHMMSS_START, format1 + HHMMSS_END);
        String[] split = format1.split("-");
        String year = split[0];
        String month = split[1];
        String startM = DateUtil.getFisrtDayOfMonth(year, month);
        String endM = DateUtil.getDateLastDay(year, month);
        Double monthVar = signalsMapper.getCalendarVar(startM + HHMMSS_START, endM + HHMMSS_END);
        CalendarVar calendarVar = new CalendarVar();
        calendarVar.setRydl(String.format("%.2f", dayVar));
        calendarVar.setYydl(String.format("%.2f", monthVar));
        return RespResultUtil.success(RespResultEnum.QUERY_SUCCESS, calendarVar);
    }

    /**
     * @param time
     * @param type
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public RespResult getPieChartData(String time, String type) {
        LocalDateTime t1 = DateUtil.getDateTimeOfTimestamp(Long.valueOf(time));
        System.out.println(t1);
        System.out.println(type);
        return RespResultUtil.success(RespResultEnum.QUERY_SUCCESS);
    }
}
