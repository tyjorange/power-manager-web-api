package com.im.pojo.first;

import java.util.Date;
import javax.persistence.*;

@Table(name = "signal_hour")
public class SignalHour {
    @Id
    private Long id;

    @Column(name = "switchID")
    private String switchid;

    private Double value;

    private Date time;

    private Integer hour;

    @Column(name = "signalsTypeID")
    private String signalstypeid;

    private Double statistik;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
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
     * @return hour
     */
    public Integer getHour() {
        return hour;
    }

    /**
     * @param hour
     */
    public void setHour(Integer hour) {
        this.hour = hour;
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
     * @return statistik
     */
    public Double getStatistik() {
        return statistik;
    }

    /**
     * @param statistik
     */
    public void setStatistik(Double statistik) {
        this.statistik = statistik;
    }
}