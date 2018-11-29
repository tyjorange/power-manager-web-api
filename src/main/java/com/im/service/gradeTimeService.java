package com.im.service;

import com.im.bean.GradeTime;
import com.im.bean.StatisticsBean;
import com.im.mapper.ApexDayMapper;
import com.im.mapper.ApexMonthMapper;
import com.im.mapper.SignalsMapper;
import com.im.mapper.SwitchMapper;
import com.im.pojo.ApexDay;
import com.im.pojo.ApexMonth;
import com.im.pojo.Signals;
import com.im.pojo.Switch;
import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.resp.RespResultUtil;
import com.im.resp.RespTableCol;
import com.im.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.DocumentDefaultsDefinition;
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
import java.util.function.DoubleBinaryOperator;

/**
 * Created by tss on 2018/11/26.
 */
@Service
public class GradeTimeService {
    @Autowired
    private SwitchMapper switchMapper;
    @Autowired
    private SignalsMapper signalsMapper;
    @Autowired
    private ApexDayMapper apexDayMapper;
    @Autowired
    private ApexMonthMapper apexMonthMapper;

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
     * 分级分时统计
     *
     * @param switchID 断路器ID
     * @param time     统计时间
     * @param timeType 统计时间类型（0：逐日；1：逐月；2：逐年）
     * @return HTTP返回值封装对象
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public RespResult gradeTimeStatistics(String switchID, String time, Integer timeType) throws ParseException {
        if (timeType != 2 && (time == null || time.isEmpty())) {
            return RespResultUtil.success(RespResultEnum.EMPTY_RESULT);
        }
        StatisticsBean statisticsBean = new StatisticsBean();   //统计实体类
        List<GradeTime> gradeTimes = new ArrayList<GradeTime>();    //分级分时统计实体列表
        if (switchID == null || switchID.isEmpty()) {    //未指定断路器则查询所有
            // 查询所有断路器列表
            List<Switch> switches = this.querySwitchList("");
            List<RespTableCol> cols = null;
            Example example = null;
            Example.Criteria criteria = null;
            if (switches != null && switches.size() != 0) {
                RespTableCol col = null;
                GradeTime gradeTime = null;
                Map<String, Double> timeValue = null;
                for (Switch _switch : switches) {
                    timeValue = new HashMap<String, Double>();
                    gradeTime = new GradeTime();
                    gradeTime.setSwitchId(_switch.getSwitchid());
                    gradeTime.setSwitchName(_switch.getName());
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
                            example = new Example(ApexDay.class);
                            criteria = example.createCriteria();
                            criteria.andEqualTo("signalstypeid", "ygdl");
                            criteria.andEqualTo("switchid", _switch.getSwitchid());
                            criteria.andEqualTo("time", queryTime);
                            List<ApexDay> apexDays = apexDayMapper.selectByExample(example);
                            if (apexDays != null && apexDays.size() != 0) {
                                timeValue.put(day, apexDays.get(0).getMaxday());
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
                            example = new Example(ApexMonth.class);
                            criteria = example.createCriteria();
                            criteria.andEqualTo("signalstypeid", "ygdl");
                            criteria.andEqualTo("switchid", _switch.getSwitchid());
                            criteria.andEqualTo("timeYear", Integer.parseInt(time));
                            criteria.andEqualTo("timeMonth", month);
                            List<ApexMonth> apexMonths = apexMonthMapper.selectByExample(example);
                            if (apexMonths != null && apexMonths.size() != 0) {
                                timeValue.put(String.format("%02d", month), apexMonths.get(0).getMaxmonth());
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
        }
        return RespResultUtil.success(RespResultEnum.QUERY_SUCCESS, statisticsBean);
    }

}
