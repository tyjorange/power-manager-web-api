package com.im.bean;

/**
 * 历史数据表.行数据-实体
 * Created by vostor on 2019/1/14.
 */
public class HisData {
    private String switchName;
    private String collectorName;
    private String signalsTypeName;
    private Double ygdl;//有功电量
    private Double wgdl;//无功电量
    private Double yggl;//有功功率
    private Double wggl;//无功功率
    private Double glys;//功率因数
    private Double dl;//电流
    private Double dy;//电压
    private Double pl;//频率
    private Double wd;//温度

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

    private String dataTime; //采集时间

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
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
