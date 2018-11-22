package com.im.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "electrical_equipment")
public class ElectricalEquipment {
    @Id
    private String id;

    @Column(name = "switchID")
    private String switchid;

    private String name;

    private Double gonglv;

    @Column(name = "addTime")
    private Date addtime;

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
     * @return gonglv
     */
    public Double getGonglv() {
        return gonglv;
    }

    /**
     * @param gonglv
     */
    public void setGonglv(Double gonglv) {
        this.gonglv = gonglv;
    }

    /**
     * @return addTime
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * @param addtime
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}