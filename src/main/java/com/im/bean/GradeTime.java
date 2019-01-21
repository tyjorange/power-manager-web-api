package com.im.bean;

import java.util.Map;

/**
 * 分级分时统计返回实体
 * Created by tss on 2018/11/26.
 */
public class GradeTime {
    private String collectorName;   //集中器名称
    private String collectorID;   //集中器ID
    private Map<String, Double> timeValue;

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getCollectorID() {
        return collectorID;
    }

    public void setCollectorID(String collectorID) {
        this.collectorID = collectorID;
    }

    public Map<String, Double> getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(Map<String, Double> timeValue) {
        this.timeValue = timeValue;
    }
}
