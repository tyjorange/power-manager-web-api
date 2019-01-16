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
    private String ygdl;//有功电量
    private String wgdl;//无功电量
    private String yggl;//有功功率
    private String wggl;//无功功率
    private String glys;//功率因数
    private String dl;//电流
    private String dy;//电压
    private String pl;//频率
    private String wd;//温度
    private String dqywgdl;//当前月无功电量
    private String dqyygdl;//当前月有功电量

    public String getSwitchID() {
        return switchID;
    }

    public void setSwitchID(String switchID) {
        this.switchID = switchID;
    }

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName;
    }

    public String getSignalsID() {
        return signalsID;
    }

    public void setSignalsID(String signalsID) {
        this.signalsID = signalsID;
    }

    public String getSignalsTypeName() {
        return signalsTypeName;
    }

    public void setSignalsTypeName(String signalsTypeName) {
        this.signalsTypeName = signalsTypeName;
    }

    public String getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(String collectorId) {
        this.collectorId = collectorId;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Long getDataTime() {
        return dataTime;
    }

    public void setDataTime(Long dataTime) {
        this.dataTime = dataTime;
    }

    public String getYgdl() {
        return ygdl;
    }

    public void setYgdl(String ygdl) {
        this.ygdl = ygdl;
    }

    public String getWgdl() {
        return wgdl;
    }

    public void setWgdl(String wgdl) {
        this.wgdl = wgdl;
    }

    public String getYggl() {
        return yggl;
    }

    public void setYggl(String yggl) {
        this.yggl = yggl;
    }

    public String getWggl() {
        return wggl;
    }

    public void setWggl(String wggl) {
        this.wggl = wggl;
    }

    public String getGlys() {
        return glys;
    }

    public void setGlys(String glys) {
        this.glys = glys;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    public String getDy() {
        return dy;
    }

    public void setDy(String dy) {
        this.dy = dy;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getDqywgdl() {
        return dqywgdl;
    }

    public void setDqywgdl(String dqywgdl) {
        this.dqywgdl = dqywgdl;
    }

    public String getDqyygdl() {
        return dqyygdl;
    }

    public void setDqyygdl(String dqyygdl) {
        this.dqyygdl = dqyygdl;
    }
}
