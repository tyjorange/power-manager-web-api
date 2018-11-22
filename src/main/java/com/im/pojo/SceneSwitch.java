package com.im.pojo;

import javax.persistence.*;

@Table(name = "scene_switch")
public class SceneSwitch {
    @Id
    private String id;

    @Column(name = "sceneID")
    private String sceneid;

    @Column(name = "switchID")
    private String switchid;

    @Column(name = "cmdData")
    private Integer cmddata;

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
     * @return sceneID
     */
    public String getSceneid() {
        return sceneid;
    }

    /**
     * @param sceneid
     */
    public void setSceneid(String sceneid) {
        this.sceneid = sceneid;
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
     * @return cmdData
     */
    public Integer getCmddata() {
        return cmddata;
    }

    /**
     * @param cmddata
     */
    public void setCmddata(Integer cmddata) {
        this.cmddata = cmddata;
    }
}