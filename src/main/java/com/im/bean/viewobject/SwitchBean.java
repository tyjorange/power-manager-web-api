package com.im.bean.viewobject;

import com.im.pojo.first.Switch;

import java.util.Date;

/**
 * 断路器信息返回页面实体类
 * Created by tss on 2019/1/22.
 */
public class SwitchBean {

    private String collectorid;
    private String collectorName;
    private String collectorCode;
    private String switchid;
    private String switchName;
    private String code;
    private Double frequency;
    private Integer icontype;
    private Integer state;
    private Integer islocked;
    private String lockeduser;
    private String lockedpwd;
    private Date addtime;
    private Integer sequence;
    private Integer fault;  //断路器故障码
    private Date faulttime; //故障码获取时间
    private Integer faultstate; //0表示未执行，1表示执行失败，2表示执行成功
    private Long switchtype;
    private Integer energyType; //能源种类

    public SwitchBean() {

    }

    public SwitchBean(Switch _switch) {
        this.collectorid = _switch.getCollectorid();
        this.switchid = _switch.getSwitchid();
        this.switchName = _switch.getName();
        this.code = _switch.getCode();
        this.frequency = _switch.getFrequency();
        this.icontype = _switch.getIcontype();
        this.state = _switch.getState();
        this.islocked = _switch.getIslocked();
        this.lockeduser = _switch.getLockeduser();
        this.lockedpwd = _switch.getLockedpwd();
        this.addtime = _switch.getAddtime();
        this.sequence = _switch.getSequence();
        this.fault = _switch.getFault();
        this.faulttime = _switch.getFaulttime();
        this.faultstate = _switch.getFaultstate();
        this.switchtype = _switch.getSwitchtype();
    }

    public String getCollectorid() {
        return collectorid;
    }

    public void setCollectorid(String collectorid) {
        this.collectorid = collectorid;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getCollectorCode() {
        return collectorCode;
    }

    public void setCollectorCode(String collectorCode) {
        this.collectorCode = collectorCode;
    }

    public String getSwitchid() {
        return switchid;
    }

    public void setSwitchid(String switchid) {
        this.switchid = switchid;
    }

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public Integer getIcontype() {
        return icontype;
    }

    public void setIcontype(Integer icontype) {
        this.icontype = icontype;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIslocked() {
        return islocked;
    }

    public void setIslocked(Integer islocked) {
        this.islocked = islocked;
    }

    public String getLockeduser() {
        return lockeduser;
    }

    public void setLockeduser(String lockeduser) {
        this.lockeduser = lockeduser;
    }

    public String getLockedpwd() {
        return lockedpwd;
    }

    public void setLockedpwd(String lockedpwd) {
        this.lockedpwd = lockedpwd;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getFault() {
        return fault;
    }

    public void setFault(Integer fault) {
        this.fault = fault;
    }

    public Date getFaulttime() {
        return faulttime;
    }

    public void setFaulttime(Date faulttime) {
        this.faulttime = faulttime;
    }

    public Integer getFaultstate() {
        return faultstate;
    }

    public void setFaultstate(Integer faultstate) {
        this.faultstate = faultstate;
    }

    public Long getSwitchtype() {
        return switchtype;
    }

    public void setSwitchtype(Long switchtype) {
        this.switchtype = switchtype;
    }

    public Integer getEnergyType() {
        return energyType;
    }

    public void setEnergyType(Integer energyType) {
        this.energyType = energyType;
    }
}
