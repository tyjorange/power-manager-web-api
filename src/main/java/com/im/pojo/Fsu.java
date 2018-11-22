package com.im.pojo;

import java.util.Date;
import javax.persistence.*;

public class Fsu {
    @Id
    @Column(name = "FSUID")
    private String fsuid;

    @Column(name = "SubRegionID")
    private String subregionid;

    @Column(name = "FSUCode")
    private String fsucode;

    @Column(name = "FSUName")
    private String fsuname;

    @Column(name = "FSULng")
    private Double fsulng;

    @Column(name = "FSULat")
    private Double fsulat;

    @Column(name = "FSULLTime")
    private Date fsulltime;

    @Column(name = "IP")
    private String ip;

    @Column(name = "CmdPort")
    private Integer cmdport;

    @Column(name = "HeartbeatTime")
    private Date heartbeattime;

    /**
     * @return FSUID
     */
    public String getFsuid() {
        return fsuid;
    }

    /**
     * @param fsuid
     */
    public void setFsuid(String fsuid) {
        this.fsuid = fsuid;
    }

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
     * @return FSUCode
     */
    public String getFsucode() {
        return fsucode;
    }

    /**
     * @param fsucode
     */
    public void setFsucode(String fsucode) {
        this.fsucode = fsucode;
    }

    /**
     * @return FSUName
     */
    public String getFsuname() {
        return fsuname;
    }

    /**
     * @param fsuname
     */
    public void setFsuname(String fsuname) {
        this.fsuname = fsuname;
    }

    /**
     * @return FSULng
     */
    public Double getFsulng() {
        return fsulng;
    }

    /**
     * @param fsulng
     */
    public void setFsulng(Double fsulng) {
        this.fsulng = fsulng;
    }

    /**
     * @return FSULat
     */
    public Double getFsulat() {
        return fsulat;
    }

    /**
     * @param fsulat
     */
    public void setFsulat(Double fsulat) {
        this.fsulat = fsulat;
    }

    /**
     * @return FSULLTime
     */
    public Date getFsulltime() {
        return fsulltime;
    }

    /**
     * @param fsulltime
     */
    public void setFsulltime(Date fsulltime) {
        this.fsulltime = fsulltime;
    }

    /**
     * @return IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return CmdPort
     */
    public Integer getCmdport() {
        return cmdport;
    }

    /**
     * @param cmdport
     */
    public void setCmdport(Integer cmdport) {
        this.cmdport = cmdport;
    }

    /**
     * @return HeartbeatTime
     */
    public Date getHeartbeattime() {
        return heartbeattime;
    }

    /**
     * @param heartbeattime
     */
    public void setHeartbeattime(Date heartbeattime) {
        this.heartbeattime = heartbeattime;
    }
}