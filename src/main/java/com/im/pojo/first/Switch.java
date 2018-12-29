package com.im.pojo.first;

import java.util.Date;
import javax.persistence.*;

public class Switch {
    @Id
    @Column(name = "switchID")
    private String switchid;

    @Column(name = "collectorID")
    private String collectorid;

    private String name;

    private String code;

    private Double frequency;

    @Column(name = "iconType")
    private Integer icontype;

    private Integer state;

    @Column(name = "isLocked")
    private Integer islocked;

    @Column(name = "lockedUser")
    private String lockeduser;

    @Column(name = "lockedPwd")
    private String lockedpwd;

    @Column(name = "addTime")
    private Date addtime;

    private Integer sequence;

    /**
     * 断路器故障码
     */
    private Integer fault;

    /**
     * 故障码获取时间
     */
    @Column(name = "faultTime")
    private Date faulttime;

    /**
     * 0表示未执行，1表示执行失败，2表示执行成功
     */
    @Column(name = "faultState")
    private Integer faultstate;

    /**
     * @return switchID
     */
    public String getSwitchid() {
        return switchid;
    }

    /**
     * @param switchid
     */
    public void setSwitchid(String switchid) {
        this.switchid = switchid;
    }

    /**
     * @return collectorID
     */
    public String getCollectorid() {
        return collectorid;
    }

    /**
     * @param collectorid
     */
    public void setCollectorid(String collectorid) {
        this.collectorid = collectorid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return frequency
     */
    public Double getFrequency() {
        return frequency;
    }

    /**
     * @param frequency
     */
    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    /**
     * @return iconType
     */
    public Integer getIcontype() {
        return icontype;
    }

    /**
     * @param icontype
     */
    public void setIcontype(Integer icontype) {
        this.icontype = icontype;
    }

    /**
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return isLocked
     */
    public Integer getIslocked() {
        return islocked;
    }

    /**
     * @param islocked
     */
    public void setIslocked(Integer islocked) {
        this.islocked = islocked;
    }

    /**
     * @return lockedUser
     */
    public String getLockeduser() {
        return lockeduser;
    }

    /**
     * @param lockeduser
     */
    public void setLockeduser(String lockeduser) {
        this.lockeduser = lockeduser;
    }

    /**
     * @return lockedPwd
     */
    public String getLockedpwd() {
        return lockedpwd;
    }

    /**
     * @param lockedpwd
     */
    public void setLockedpwd(String lockedpwd) {
        this.lockedpwd = lockedpwd;
    }

    /**
     * @return addTime
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * @param addtime
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * @return sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * @param sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 获取断路器故障码
     *
     * @return fault - 断路器故障码
     */
    public Integer getFault() {
        return fault;
    }

    /**
     * 设置断路器故障码
     *
     * @param fault 断路器故障码
     */
    public void setFault(Integer fault) {
        this.fault = fault;
    }

    /**
     * 获取故障码获取时间
     *
     * @return faultTime - 故障码获取时间
     */
    public Date getFaulttime() {
        return faulttime;
    }

    /**
     * 设置故障码获取时间
     *
     * @param faulttime 故障码获取时间
     */
    public void setFaulttime(Date faulttime) {
        this.faulttime = faulttime;
    }

    /**
     * 获取0表示未执行，1表示执行失败，2表示执行成功
     *
     * @return faultState - 0表示未执行，1表示执行失败，2表示执行成功
     */
    public Integer getFaultstate() {
        return faultstate;
    }

    /**
     * 设置0表示未执行，1表示执行失败，2表示执行成功
     *
     * @param faultstate 0表示未执行，1表示执行失败，2表示执行成功
     */
    public void setFaultstate(Integer faultstate) {
        this.faultstate = faultstate;
    }
}