package com.im.bean;

import java.sql.Timestamp;

/**
 * 历史数据表.行数据-实体
 * Created by vostor on 2019/1/14.
 */
public class HisData {
    private String switchID;
    private String switchName;
    private String signalsID;
    private String signalsTypeName;
    private String collectorId;
    private String collectorName;
    private Timestamp time;// 采集时间 yyyy-mm-dd hh:mm:ss
    private Long dataTime; //采集时间 ms
    private Double ygdl;//有功电量
    private Double wgdl;//无功电量
    private Double yggl;//有功功率
    private Double wggl;//无功功率
    private Double glys;//功率因数
    private Double dl;//电流
    private Double dy;//电压
    private Double pl;//频率
    private Double wd;//温度
    private Double dqywgdl;//当前月无功电量
    private Double dqyygdl;//当前月有功电量

    public String getSwitchID() {
        return switchID;
    }

    public void setSwitchID(String switchID) {
        this.switchID = switchID;
    }

    public String getSignalsID() {
        return signalsID;
    }

    public void setSignalsID(String signalsID) {
        this.signalsID = signalsID;
    }

    public String getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(String collectorId) {
        this.collectorId = collectorId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Double getDqywgdl() {
        return dqywgdl;
    }

    public void setDqywgdl(Double dqywgdl) {
        this.dqywgdl = dqywgdl;
    }

    public Double getDqyygdl() {
        return dqyygdl;
    }

    public void setDqyygdl(Double dqyygdl) {
        this.dqyygdl = dqyygdl;
    }

    public Double getGlys() {
        return glys;
    }

    public void setGlys(Double glys) {
        this.glys = glys;
    }

    public Double getDl() {
        return dl;
    }

    public void setDl(Double dl) {
        this.dl = dl;
    }

    public Double getDy() {
        return dy;
    }

    public void setDy(Double dy) {
        this.dy = dy;
    }

    public Double getPl() {
        return pl;
    }

    public void setPl(Double pl) {
        this.pl = pl;
    }

    public Double getWd() {
        return wd;
    }

    public void setWd(Double wd) {
        this.wd = wd;
    }


    public Long getDataTime() {
        return dataTime;
    }

    public void setDataTime(Long dataTime) {
        this.dataTime = dataTime;
    }

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

    public Double getYgdl() {
        return ygdl;
    }

    public void setYgdl(Double ygdl) {
        this.ygdl = ygdl;
    }

    public Double getWgdl() {
        return wgdl;
    }

    public void setWgdl(Double wgdl) {
        this.wgdl = wgdl;
    }

    public Double getYggl() {
        return yggl;
    }

    public void setYggl(Double yggl) {
        this.yggl = yggl;
    }

    public Double getWggl() {
        return wggl;
    }

    public void setWggl(Double wggl) {
        this.wggl = wggl;
    }
}
