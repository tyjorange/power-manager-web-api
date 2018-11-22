package com.im.pojo;

import javax.persistence.*;

public class Automation {
    @Id
    @Column(name = "automationID")
    private String automationid;

    @Column(name = "switchID")
    private String switchid;

    private String name;

    /**
     * @return automationID
     */
    public String getAutomationid() {
        return automationid;
    }

    /**
     * @param automationid
     */
    public void setAutomationid(String automationid) {
        this.automationid = automationid;
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
}