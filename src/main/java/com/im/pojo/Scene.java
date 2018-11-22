package com.im.pojo;

import javax.persistence.*;

public class Scene {
    @Id
    @Column(name = "sceneID")
    private String sceneid;

    @Column(name = "userID")
    private String userid;

    private String name;

    @Column(name = "iconType")
    private Integer icontype;

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
     * @return iconType
     */
    public Integer getIcontype() {
        return icontype;
    }

    /**
     * @param icontype
     */
    public void setIcontype(Integer icontype) {
        this.icontype = icontype;
    }
}