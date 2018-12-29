package com.im.pojo.first;

import java.util.Date;
import javax.persistence.*;

@Table(name = "switch_param")
public class SwitchParam {
    @Id
    private String id;

    @Column(name = "switchID")
    private String switchid;

    @Column(name = "paramID")
    private Integer paramid;

    @Column(name = "paramValue")
    private String paramvalue;

    @Column(name = "genTime")
    private Date gentime;

    private Integer state;

    @Column(name = "returnTime")
    private Date returntime;

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
     * @return paramID
     */
    public Integer getParamid() {
        return paramid;
    }

    /**
     * @param paramid
     */
    public void setParamid(Integer paramid) {
        this.paramid = paramid;
    }

    /**
     * @return paramValue
     */
    public String getParamvalue() {
        return paramvalue;
    }

    /**
     * @param paramvalue
     */
    public void setParamvalue(String paramvalue) {
        this.paramvalue = paramvalue;
    }

    /**
     * @return genTime
     */
    public Date getGentime() {
        return gentime;
    }

    /**
     * @param gentime
     */
    public void setGentime(Date gentime) {
        this.gentime = gentime;
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
     * @return returnTime
     */
    public Date getReturntime() {
        return returntime;
    }

    /**
     * @param returntime
     */
    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }
}