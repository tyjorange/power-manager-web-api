package com.im.pojo;

import javax.persistence.*;

public class Conditions {
    @Id
    @Column(name = "conditionsID")
    private String conditionsid;

    @Column(name = "automationID")
    private String automationid;

    @Column(name = "signalsTypeID")
    private String signalstypeid;

    private String threshold;

    /**
     * @return conditionsID
     */
    public String getConditionsid() {
        return conditionsid;
    }

    /**
     * @param conditionsid
     */
    public void setConditionsid(String conditionsid) {
        this.conditionsid = conditionsid;
    }

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
     * @return signalsTypeID
     */
    public String getSignalstypeid() {
        return signalstypeid;
    }

    /**
     * @param signalstypeid
     */
    public void setSignalstypeid(String signalstypeid) {
        this.signalstypeid = signalstypeid;
    }

    /**
     * @return threshold
     */
    public String getThreshold() {
        return threshold;
    }

    /**
     * @param threshold
     */
    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }
}