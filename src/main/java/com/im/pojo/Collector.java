package com.im.pojo;

import java.util.Date;
import javax.persistence.*;

public class Collector {
    @Id
    @Column(name = "collectorID")
    private String collectorid;

    @Column(name = "fsuID")
    private String fsuid;

    private String name;

    private String code;

    private Integer baud;

    private Integer freq;

    private Integer ranges;

    @Column(name = "HBFreq")
    private Integer hbfreq;

    @Column(name = "HBTime")
    private Date hbtime;

    @Column(name = "setupCode")
    private String setupcode;

    @Column(name = "srvIP")
    private String srvip;

    @Column(name = "srvPort")
    private Integer srvport;

    /**
     * 0表示故障信息未执行，1表示执行失败，2表示执行成功
     */
    @Column(name = "faultState")
    private Integer faultstate;

    /**
     * 故障记录返回时间
     */
    @Column(name = "faultTime")
    private Date faulttime;

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
     * @return fsuID
     */
    public String getFsuid() {
        return fsuid;
    }

    /**
     * @param fsuid
     */
    public void setFsuid(String fsuid) {
        this.fsuid = fsuid;
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
     * @return baud
     */
    public Integer getBaud() {
        return baud;
    }

    /**
     * @param baud
     */
    public void setBaud(Integer baud) {
        this.baud = baud;
    }

    /**
     * @return freq
     */
    public Integer getFreq() {
        return freq;
    }

    /**
     * @param freq
     */
    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    /**
     * @return ranges
     */
    public Integer getRanges() {
        return ranges;
    }

    /**
     * @param ranges
     */
    public void setRanges(Integer ranges) {
        this.ranges = ranges;
    }

    /**
     * @return HBFreq
     */
    public Integer getHbfreq() {
        return hbfreq;
    }

    /**
     * @param hbfreq
     */
    public void setHbfreq(Integer hbfreq) {
        this.hbfreq = hbfreq;
    }

    /**
     * @return HBTime
     */
    public Date getHbtime() {
        return hbtime;
    }

    /**
     * @param hbtime
     */
    public void setHbtime(Date hbtime) {
        this.hbtime = hbtime;
    }

    /**
     * @return setupCode
     */
    public String getSetupcode() {
        return setupcode;
    }

    /**
     * @param setupcode
     */
    public void setSetupcode(String setupcode) {
        this.setupcode = setupcode;
    }

    /**
     * @return srvIP
     */
    public String getSrvip() {
        return srvip;
    }

    /**
     * @param srvip
     */
    public void setSrvip(String srvip) {
        this.srvip = srvip;
    }

    /**
     * @return srvPort
     */
    public Integer getSrvport() {
        return srvport;
    }

    /**
     * @param srvport
     */
    public void setSrvport(Integer srvport) {
        this.srvport = srvport;
    }

    /**
     * 获取0表示故障信息未执行，1表示执行失败，2表示执行成功
     *
     * @return faultState - 0表示故障信息未执行，1表示执行失败，2表示执行成功
     */
    public Integer getFaultstate() {
        return faultstate;
    }

    /**
     * 设置0表示故障信息未执行，1表示执行失败，2表示执行成功
     *
     * @param faultstate 0表示故障信息未执行，1表示执行失败，2表示执行成功
     */
    public void setFaultstate(Integer faultstate) {
        this.faultstate = faultstate;
    }

    /**
     * 获取故障记录返回时间
     *
     * @return faultTime - 故障记录返回时间
     */
    public Date getFaulttime() {
        return faulttime;
    }

    /**
     * 设置故障记录返回时间
     *
     * @param faulttime 故障记录返回时间
     */
    public void setFaulttime(Date faulttime) {
        this.faulttime = faulttime;
    }
}