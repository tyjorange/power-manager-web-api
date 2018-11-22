package com.im.pojo;

import javax.persistence.*;

@Table(name = "apex_month")
public class ApexMonth {
    @Id
    private Long id;

    @Column(name = "signalsTypeID")
    private String signalstypeid;

    @Column(name = "time_year")
    private Integer timeYear;

    @Column(name = "time_month")
    private Integer timeMonth;

    @Column(name = "switchID")
    private String switchid;

    @Column(name = "maxMonth")
    private Double maxmonth;

    @Column(name = "minMonth")
    private Double minmonth;

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
     * @return time_year
     */
    public Integer getTimeYear() {
        return timeYear;
    }

    /**
     * @param timeYear
     */
    public void setTimeYear(Integer timeYear) {
        this.timeYear = timeYear;
    }

    /**
     * @return time_month
     */
    public Integer getTimeMonth() {
        return timeMonth;
    }

    /**
     * @param timeMonth
     */
    public void setTimeMonth(Integer timeMonth) {
        this.timeMonth = timeMonth;
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
     * @return maxMonth
     */
    public Double getMaxmonth() {
        return maxmonth;
    }

    /**
     * @param maxmonth
     */
    public void setMaxmonth(Double maxmonth) {
        this.maxmonth = maxmonth;
    }

    /**
     * @return minMonth
     */
    public Double getMinmonth() {
        return minmonth;
    }

    /**
     * @param minmonth
     */
    public void setMinmonth(Double minmonth) {
        this.minmonth = minmonth;
    }
}