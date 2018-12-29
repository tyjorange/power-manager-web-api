package com.im.pojo.first;

import java.util.Date;
import javax.persistence.*;

public class Signals {
    @Id
    @Column(name = "signalsID")
    private Long signalsid;

    @Id
    private Date time;

    /**
     * 标签id
     */
    @Column(name = "switchID")
    private String switchid;

    @Column(name = "signalsTypeID")
    private String signalstypeid;

    private Double value;

    /**
     * @return signalsID
     */
    public Long getSignalsid() {
        return signalsid;
    }

    /**
     * @param signalsid
     */
    public void setSignalsid(Long signalsid) {
        this.signalsid = signalsid;
    }

    /**
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取标签id
     *
     * @return switchID - 标签id
     */
    public String getSwitchid() {
        return switchid;
    }

    /**
     * 设置标签id
     *
     * @param switchid 标签id
     */
    public void setSwitchid(String switchid) {
        this.switchid = switchid;
    }

    /**
     * @return signalsTypeID
     */
    public String getSignalstypeid() {
        return signalstypeid;
    }

    /**
     * @param signalstypeid
     */
    public void setSignalstypeid(String signalstypeid) {
        this.signalstypeid = signalstypeid;
    }

    /**
     * @return value
     */
    public Double getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(Double value) {
        this.value = value;
    }
}