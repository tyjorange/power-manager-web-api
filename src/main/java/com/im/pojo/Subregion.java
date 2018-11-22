package com.im.pojo;

import javax.persistence.*;

public class Subregion {
    @Id
    @Column(name = "SubRegionID")
    private String subregionid;

    @Column(name = "RegionID")
    private String regionid;

    @Column(name = "SubRegionCode")
    private String subregioncode;

    @Column(name = "SubRegionName")
    private String subregionname;

    /**
     * @return SubRegionID
     */
    public String getSubregionid() {
        return subregionid;
    }

    /**
     * @param subregionid
     */
    public void setSubregionid(String subregionid) {
        this.subregionid = subregionid;
    }

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
     * @return SubRegionCode
     */
    public String getSubregioncode() {
        return subregioncode;
    }

    /**
     * @param subregioncode
     */
    public void setSubregioncode(String subregioncode) {
        this.subregioncode = subregioncode;
    }

    /**
     * @return SubRegionName
     */
    public String getSubregionname() {
        return subregionname;
    }

    /**
     * @param subregionname
     */
    public void setSubregionname(String subregionname) {
        this.subregionname = subregionname;
    }
}