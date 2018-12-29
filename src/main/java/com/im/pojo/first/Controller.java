package com.im.pojo.first;

import java.util.Date;
import javax.persistence.*;

public class Controller {
    @Id
    @Column(name = "controllerID")
    private String controllerid;

    /**
     * 断路器id或者场景id
     */
    @Column(name = "targetID")
    private String targetid;

    /**
     * 0表示断路器，1表示场景
     */
    @Column(name = "targetType")
    private Integer targettype;

    /**
     * 记录生成时间
     */
    @Column(name = "genTime")
    private Date gentime;

    /**
     * 0表示断路器断开，1表示断路器合闸
     */
    @Column(name = "cmdData")
    private Integer cmddata;

    /**
     * 命令发送给集中器的时间
     */
    @Column(name = "runTime")
    private Date runtime;

    /**
     * 命令发送给集中器的结果，0表示取出命令准备执行，1表示发送失败，2表示发送成功
     */
    @Column(name = "runCode")
    private String runcode;

    /**
     * 集中器命令id
     */
    @Column(name = "runId")
    private Integer runid;

    /**
     * 集中器命令流水号
     */
    @Column(name = "runNo")
    private Integer runno;

    /**
     * 通用应答消息的结果
     */
    @Column(name = "runResult")
    private Integer runresult;

    /**
     * 0表示远程执行，1表示定时执行
     */
    private Integer source;

    /**
     * @return controllerID
     */
    public String getControllerid() {
        return controllerid;
    }

    /**
     * @param controllerid
     */
    public void setControllerid(String controllerid) {
        this.controllerid = controllerid;
    }

    /**
     * 获取断路器id或者场景id
     *
     * @return targetID - 断路器id或者场景id
     */
    public String getTargetid() {
        return targetid;
    }

    /**
     * 设置断路器id或者场景id
     *
     * @param targetid 断路器id或者场景id
     */
    public void setTargetid(String targetid) {
        this.targetid = targetid;
    }

    /**
     * 获取0表示断路器，1表示场景
     *
     * @return targetType - 0表示断路器，1表示场景
     */
    public Integer getTargettype() {
        return targettype;
    }

    /**
     * 设置0表示断路器，1表示场景
     *
     * @param targettype 0表示断路器，1表示场景
     */
    public void setTargettype(Integer targettype) {
        this.targettype = targettype;
    }

    /**
     * 获取记录生成时间
     *
     * @return genTime - 记录生成时间
     */
    public Date getGentime() {
        return gentime;
    }

    /**
     * 设置记录生成时间
     *
     * @param gentime 记录生成时间
     */
    public void setGentime(Date gentime) {
        this.gentime = gentime;
    }

    /**
     * 获取0表示断路器断开，1表示断路器合闸
     *
     * @return cmdData - 0表示断路器断开，1表示断路器合闸
     */
    public Integer getCmddata() {
        return cmddata;
    }

    /**
     * 设置0表示断路器断开，1表示断路器合闸
     *
     * @param cmddata 0表示断路器断开，1表示断路器合闸
     */
    public void setCmddata(Integer cmddata) {
        this.cmddata = cmddata;
    }

    /**
     * 获取命令发送给集中器的时间
     *
     * @return runTime - 命令发送给集中器的时间
     */
    public Date getRuntime() {
        return runtime;
    }

    /**
     * 设置命令发送给集中器的时间
     *
     * @param runtime 命令发送给集中器的时间
     */
    public void setRuntime(Date runtime) {
        this.runtime = runtime;
    }

    /**
     * 获取命令发送给集中器的结果，0表示取出命令准备执行，1表示发送失败，2表示发送成功
     *
     * @return runCode - 命令发送给集中器的结果，0表示取出命令准备执行，1表示发送失败，2表示发送成功
     */
    public String getRuncode() {
        return runcode;
    }

    /**
     * 设置命令发送给集中器的结果，0表示取出命令准备执行，1表示发送失败，2表示发送成功
     *
     * @param runcode 命令发送给集中器的结果，0表示取出命令准备执行，1表示发送失败，2表示发送成功
     */
    public void setRuncode(String runcode) {
        this.runcode = runcode;
    }

    /**
     * 获取集中器命令id
     *
     * @return runId - 集中器命令id
     */
    public Integer getRunid() {
        return runid;
    }

    /**
     * 设置集中器命令id
     *
     * @param runid 集中器命令id
     */
    public void setRunid(Integer runid) {
        this.runid = runid;
    }

    /**
     * 获取集中器命令流水号
     *
     * @return runNo - 集中器命令流水号
     */
    public Integer getRunno() {
        return runno;
    }

    /**
     * 设置集中器命令流水号
     *
     * @param runno 集中器命令流水号
     */
    public void setRunno(Integer runno) {
        this.runno = runno;
    }

    /**
     * 获取通用应答消息的结果
     *
     * @return runResult - 通用应答消息的结果
     */
    public Integer getRunresult() {
        return runresult;
    }

    /**
     * 设置通用应答消息的结果
     *
     * @param runresult 通用应答消息的结果
     */
    public void setRunresult(Integer runresult) {
        this.runresult = runresult;
    }

    /**
     * 获取0表示远程执行，1表示定时执行
     *
     * @return source - 0表示远程执行，1表示定时执行
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 设置0表示远程执行，1表示定时执行
     *
     * @param source 0表示远程执行，1表示定时执行
     */
    public void setSource(Integer source) {
        this.source = source;
    }
}