package com.im.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "signals_new")
public class SignalsNew {
    @Id
    @Column(name = "signalsID")
    private String signalsid;

    @Column(name = "switchID")
    private String switchid;

    private Date time;

    @Column(name = "signalsTypeID")
    private String signalstypeid;

    private Double value;

    /**
     * @return signalsID
     */
    public String getSignalsid() {
        return signalsid;
    }

    /**
     * @param signalsid
     */
    public void setSignalsid(String signalsid) {
        this.signalsid = signalsid;
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