package com.im.bean;

/**
 * 实时数据表.行数据-实体
 * Created by vostor on 2019/1/10.
 */
public class RealData {
    private String switchName;
    private String collectorName;
    private String signalsTypeName;
    private String fl; //费率
    private String bl; //倍率
    private String dataValue;
    private String dataUnit; //计量单位
    private String dataLoop; //采集周期
    private String dataTime; //采集时间

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getSignalsTypeName() {
        return signalsTypeName;
    }

    public void setSignalsTypeName(String signalsTypeName) {
        this.signalsTypeName = signalsTypeName;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getBl() {
        return bl;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataUnit() {
        return dataUnit;
    }

    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit;
    }

    public String getDataLoop() {
        return dataLoop;
    }

    public void setDataLoop(String dataLoop) {
        this.dataLoop = dataLoop;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }
}
