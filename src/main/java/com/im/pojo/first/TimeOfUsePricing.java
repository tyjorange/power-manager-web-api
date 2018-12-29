package com.im.pojo.first;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "time_of_use_pricing")
public class TimeOfUsePricing {
    @Id
    private String id;

    @Column(name = "userID")
    private String userid;

    @Column(name = "timePoint")
    private Integer timepoint;

    private Double price;

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
     * @return userID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return timePoint
     */
    public Integer getTimepoint() {
        return timepoint;
    }

    /**
     * @param timepoint
     */
    public void setTimepoint(Integer timepoint) {
        this.timepoint = timepoint;
    }

    /**
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}