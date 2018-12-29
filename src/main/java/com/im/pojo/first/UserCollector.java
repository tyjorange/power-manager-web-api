package com.im.pojo.first;

import javax.persistence.*;

@Table(name = "user_collector")
public class UserCollector {
    @Id
    private String id;

    @Column(name = "userID")
    private String userid;

    @Column(name = "collectorID")
    private String collectorid;

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
}