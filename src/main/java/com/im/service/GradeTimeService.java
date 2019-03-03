package com.im.service;

import com.im.bean.viewobject.GradeTime;
import com.im.bean.viewobject.StatisticsBean;
import com.im.mapper.first.CollectorMapper;
import com.im.mapper.first.SignalHourMapper;
import com.im.pojo.first.Collector;
import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
import com.im.resp.RespTableCol;
import com.im.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分级分时统计
 * Created by tss on 2018/11/26.
 */
@Service
public class GradeTimeService {
    @Autowired
    private SignalHourMapper signalHourMapper;
    @Autowired
    private CollectorMapper collectorMapper;

    /**
     * 分级分时统计
     *
     * @param collectorID 集中器ID
     * @param time     统计时间
     * @param timeType 统计时间类型（0：逐日；1：逐月；2：逐年）
     * @return HTTP返回值封装对象
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse gradeTime(String collectorID, String time, Integer timeType) throws ParseException {
        if (timeType != 2 && (time == null || time.isEmpty())) {
            return ServerResponse.success(ResponseCode.EMPTY_RESULT);
        }
        StatisticsBean statisticsBean = new StatisticsBean();   //统计实体类
        List<GradeTime> gradeTimes = new ArrayList<GradeTime>();    //分级分时统计实体列表
        List<Collector> collectors = new ArrayList<Collector>();
        List<RespTableCol> cols = null;
        Example example = null;
        Example.Criteria criteria = null;
        if (collectorID == null || collectorID.isEmpty()) {    //未指定集中器则查询所有
            //获取所有在使用的集中器列表
            collectors = collectorMapper.getUsedCollector();
        } else {
            Collector collector = collectorMapper.selectByPrimaryKey(collectorID);
            collectors.add(collector);
        }
        if (collectors != null && collectors.size() != 0) {
            RespTableCol col = null;
            GradeTime gradeTime = null;
            Map<String, Double> timeValue = null;
            Double statistik;
            for (Collector collector : collectors) {
                timeValue = new HashMap<String, Double>();
                gradeTime = new GradeTime();
                gradeTime.setCollectorID(collector.getCollectorid());
                gradeTime.setCollectorName(collector.getName());
                cols = new ArrayList<RespTableCol>();
                if (timeType == 0) {  //逐日
                    //获取当前月份的天数
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                    int dayOfMonth = DateUtil.getDaysOfMonth(sdf.parse(time));
                    String queryTime = "";
                    String day;
                    //逐日查询能耗信息
                    for (int i = 1; i <= dayOfMonth; i++) {
                        day = String.format("%02d", i);
                        col = new RespTableCol();
                        col.setLabel(day);
                        col.setProp("timeValue."+day);
                        cols.add(col);
                        queryTime = time + "-" + day;
                        statistik = signalHourMapper.getSignalDay(queryTime, collector.getCollectorid());
                        if (statistik != null) {
                            timeValue.put(day, statistik);
                        } else {
                            timeValue.put(day, Double.valueOf(0));
                        }
                    }
                } else if (timeType == 1) {   //逐月
                    for (int month = 1; month <= 12; month++) {
                        col = new RespTableCol();
                        col.setLabel(String.format("%02d", month));
                        col.setProp("timeValue."+String.format("%02d", month));
                        cols.add(col);
                        String startTime = DateUtil.getFisrtDayOfMonth(time, String.format("%02d", month));
                        String endTime = DateUtil.getDateLastDay(time, String.format("%02d", month));
                        statistik = signalHourMapper.getSignalMonth(startTime, endTime, collector.getCollectorid());
                        if (statistik != null) {
                            timeValue.put(String.format("%02d", month), statistik);
                        } else {
                            timeValue.put(String.format("%02d", month), Double.valueOf(0));
                        }
                    }
                }
                gradeTime.setTimeValue(timeValue);
                gradeTimes.add(gradeTime);
            }
            statisticsBean.setCols(cols);
            statisticsBean.setTableData(gradeTimes);
        }
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, statisticsBean);
    }

}
