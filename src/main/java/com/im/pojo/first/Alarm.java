package com.im.pojo.first;

import java.util.Date;
import javax.persistence.*;

public class Alarm {
    @Id
    private String id;

    @Column(name = "switchID")
    private String switchid;

    @Column(name = "collectorID")
    private String collectorid;

    /**
     * 区别故障或者告警
     */
    private Integer type;

    private Date time;

    /**
     * 描述
     */
    private String desc;

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
     * 获取区别故障或者告警
     *
     * @return type - 区别故障或者告警
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置区别故障或者告警
     *
     * @param type 区别故障或者告警
     */
    public void setType(Integer type) {
        this.type = type;
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
     * 获取描述
     *
     * @return desc - 描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置描述
     *
     * @param desc 描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}