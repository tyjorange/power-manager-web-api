package com.im.bean;

import com.im.pojo.Switch;

import java.util.List;
import java.util.Map;

/**
 * 分级分时统计返回实体
 * Created by tss on 2018/11/26.
 */
public class GradeTime {
    private String switchId;
    private String switchName;
    private Map<String, Double> timeValue;

    public String getSwitchId() {
        return switchId;
    }

    public void setSwitchId(String switchId) {
        this.switchId = switchId;
    }

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName;
    }

    public Map<String, Double> getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(Map<String, Double> timeValue) {
        this.timeValue = timeValue;
    }
}
