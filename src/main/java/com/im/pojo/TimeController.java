package com.im.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "time_controller")
public class TimeController {
    @Id
    private String id;

    @Column(name = "switchID")
    private String switchid;

    @Column(name = "runTime")
    private Date runtime;

    /**
     * 0表示不重复,其他值表示重复,由或运算得到
     */
    private Integer weekday;

    /**
     * 0表示无效,1表示有效
     */
    private Integer state;

    /**
     * 0表示关,1表示开
     */
    @Column(name = "cmdData")
    private Integer cmddata;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

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
     * @return runTime
     */
    public Date getRuntime() {
        return runtime;
    }

    /**
     * @param runtime
     */
    public void setRuntime(Date runtime) {
        this.runtime = runtime;
    }

    /**
     * 获取0表示不重复,其他值表示重复,由或运算得到
     *
     * @return weekday - 0表示不重复,其他值表示重复,由或运算得到
     */
    public Integer getWeekday() {
        return weekday;
    }

    /**
     * 设置0表示不重复,其他值表示重复,由或运算得到
     *
     * @param weekday 0表示不重复,其他值表示重复,由或运算得到
     */
    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    /**
     * 获取0表示无效,1表示有效
     *
     * @return state - 0表示无效,1表示有效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0表示无效,1表示有效
     *
     * @param state 0表示无效,1表示有效
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取0表示关,1表示开
     *
     * @return cmdData - 0表示关,1表示开
     */
    public Integer getCmddata() {
        return cmddata;
    }

    /**
     * 设置0表示关,1表示开
     *
     * @param cmddata 0表示关,1表示开
     */
    public void setCmddata(Integer cmddata) {
        this.cmddata = cmddata;
    }
}