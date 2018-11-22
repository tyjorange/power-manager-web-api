package com.im.pojo;

import javax.persistence.*;

public class Region {
    @Id
    @Column(name = "RegionID")
    private String regionid;

    @Column(name = "RegionCode")
    private String regioncode;

    @Column(name = "RegionName")
    private String regionname;

    /**
     * @return RegionID
     */
    public String getRegionid() {
        return regionid;
    }

    /**
     * @param regionid
     */
    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    /**
     * @return RegionCode
     */
    public String getRegioncode() {
        return regioncode;
    }

    /**
     * @param regioncode
     */
    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode;
    }

    /**
     * @return RegionName
     */
    public String getRegionname() {
        return regionname;
    }

    /**
     * @param regionname
     */
    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }
}