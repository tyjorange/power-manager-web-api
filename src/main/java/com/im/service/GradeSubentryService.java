package com.im.service;

import com.im.bean.viewobject.GradeSubentry;
import com.im.bean.viewobject.StatisticsBean;
import com.im.mapper.first.ApexDayMapper;
import com.im.mapper.first.ApexMonthMapper;
import com.im.mapper.first.CollectorMapper;
import com.im.mapper.first.SignalHourMapper;
import com.im.pojo.first.ApexMonth;
import com.im.pojo.first.Collector;
import com.im.pojo.first.Switch;
import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
import com.im.resp.RespTableCol;
import com.im.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * 分级分项统计
 * Created by tss on 2018/11/30.
 */
@Service
public class GradeSubentryService {

    @Autowired
    private CollectorMapper collectorMapper;
    @Autowired
    private SignalHourMapper signalHourMapper;
    @Autowired
    private ApexDayMapper apexDayMapper;
    @Autowired
    private ApexMonthMapper apexMonthMapper;
    @Autowired
    private SwitchService switchService;

    /**
     * 分级分项统计
     *
     * @param collectorID
     * @param startTime
     * @param endTime
     * @param timeType
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse gradeSubentry(String collectorID, String startTime, String endTime, Integer timeType) {
        List<Collector> collectors = new ArrayList<Collector>();
        List<GradeSubentry> gradeSubentries = null;
        if (collectorID == null || collectorID.isEmpty()) {
            //获取所有在使用的集中器列表
            collectors = collectorMapper.getUsedCollector();
        } else {
            Collector collector = collectorMapper.selectByPrimaryKey(collectorID);
            collectors.add(collector);
        }
        if (collectors != null && collectors.size() != 0) {
            String start = "";
            String end = "";
            gradeSubentries = new ArrayList<GradeSubentry>();
            GradeSubentry gradeSubentry = null;
            for (Collector collector : collectors) {
                if (timeType == 0) {    //自定义查询
                    start = startTime;
                    end = endTime;
                } else if (timeType == 1) {    //按月查询
                    String year = startTime.split("-")[0];
                    String month = startTime.split("-")[1];
                    start = DateUtil.getFisrtDayOfMonth(year, month);
                    end = DateUtil.getDateLastDay(year, month);
                } else if (timeType == 2) {  //按年查询
                    int year = Integer.parseInt(startTime);
                    start = DateUtil.getYearFirst(year);
                    end = DateUtil.getYearLast(year);
                }
                gradeSubentry = signalHourMapper.gradeSubentry(start, end, collector.getCollectorid());
                gradeSubentry.setComprehensive(gradeSubentry.mathComprehensive());
                gradeSubentries.add(gradeSubentry);
            }
        }
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, gradeSubentries);
    }

    /**
     * 分类分时统计
     *
     * @param collectorID
     * @param startTime
     * @param endTime
     * @param timeType
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse gradeSubentry1(String collectorID, String startTime, String endTime, Integer timeType) {
        List<Switch> switches = null;
        StatisticsBean statisticsBean = new StatisticsBean();
        List<RespTableCol> cols = null;
        List<Map<String, String>> datas = new ArrayList<Map<String, String>>();
        //获取该集中器下的断路器列表
        switches = switchService.findByCollectorID(collectorID);
        if (switches != null && switches.size() != 0) {
            Map<String, String> map = new HashMap<>();
            Collector collector = collectorMapper.selectByPrimaryKey(collectorID);
            map.put("collector", collector.getName());
            cols = new ArrayList<RespTableCol>();
            RespTableCol col = null;
            Double ygdl = null;
            for (Switch _switch : switches) {
                //构造返回表头列表
                col = new RespTableCol();
                col.setLabel(_switch.getName());
                col.setProp(_switch.getSwitchid());
                col.setKey(_switch.getSwitchid());
                cols.add(col);
                if (timeType == 0) {  //自定义统计时间
                    if (startTime == null || startTime.isEmpty() || endTime == null || endTime.isEmpty()) {
                        return ServerResponse.success(ResponseCode.EMPTY_RESULT);
                    } else {
                        // 查询时间段内该断路器的有功电量
                        ygdl = apexDayMapper.getMaxSum(_switch.getSwitchid(), "ygdl", startTime, endTime);
                        map.put(_switch.getSwitchid(), String.format("%.3f", ygdl));
                    }
                } else if (timeType == 1) {  //按月统计
                    if (startTime == null || startTime.isEmpty()) {
                        return ServerResponse.success(ResponseCode.EMPTY_RESULT);
                    } else {
                        // 查询该月内该断路器的有功电量
                        Integer year = Integer.parseInt(startTime.split("-")[0]);
                        Integer month = Integer.parseInt(startTime.split("-")[1]);
                        Example example = new Example(ApexMonth.class);
                        Example.Criteria criteria = example.createCriteria();
                        criteria.andEqualTo("signalstypeid", "ygdl");
                        criteria.andEqualTo("switchid", _switch.getSwitchid());
                        criteria.andEqualTo("timeYear", year);
                        criteria.andEqualTo("timeMonth", month);
                        List<ApexMonth> apexMonths = apexMonthMapper.selectByExample(example);
                        if (apexMonths != null && apexMonths.size() != 0) {
                            map.put(_switch.getSwitchid(), String.format("%.3f", apexMonths.get(0).getMaxmonth()));
                        } else {
                            map.put(_switch.getSwitchid(), "--");
                        }
                    }
                }
            }
            datas.add(map);
            statisticsBean.setCols(cols);
            statisticsBean.setDatas(datas);
        }
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, statisticsBean);
    }

    /**
     * @param switchID
     * @param signalsType
     * @param startTime
     * @param endTime
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Double apexDayStatistics(String switchID, String signalsType, String startTime, String endTime) {
        return apexDayMapper.getMaxSum(switchID, signalsType, startTime, endTime);
    }


}