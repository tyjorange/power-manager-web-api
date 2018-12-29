package com.im.pojo.first;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "apex_day")
public class ApexDay {
    @Id
    private Long id;

    @Column(name = "signalsTypeID")
    private String signalstypeid;

    private Date time;

    @Column(name = "switchID")
    private String switchid;

    @Column(name = "maxDay")
    private Double maxday;

    @Column(name = "minDay")
    private Double minday;

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
     * @return maxDay
     */
    public Double getMaxday() {
        return maxday;
    }

    /**
     * @param maxday
     */
    public void setMaxday(Double maxday) {
        this.maxday = maxday;
    }

    /**
     * @return minDay
     */
    public Double getMinday() {
        return minday;
    }

    /**
     * @param minday
     */
    public void setMinday(Double minday) {
        this.minday = minday;
    }
}