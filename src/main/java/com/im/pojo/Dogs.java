package com.im.pojo;

import javax.persistence.*;

public class Dogs {
    @Id
    @Column(name = "dog_id")
    private Integer dogId;

    @Column(name = "dog_age")
    private Integer dogAge;

    @Column(name = "dog_name")
    private String dogName;

    @Column(name = "dog_desc")
    private String dogDesc;

    /**
     * @return dog_id
     */
    public Integer getDogId() {
        return dogId;
    }

    /**
     * @param dogId
     */
    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    /**
     * @return dog_age
     */
    public Integer getDogAge() {
        return dogAge;
    }

    /**
     * @param dogAge
     */
    public void setDogAge(Integer dogAge) {
        this.dogAge = dogAge;
    }

    /**
     * @return dog_name
     */
    public String getDogName() {
        return dogName;
    }

    /**
     * @param dogName
     */
    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    /**
     * @return dog_desc
     */
    public String getDogDesc() {
        return dogDesc;
    }

    /**
     * @param dogDesc
     */
    public void setDogDesc(String dogDesc) {
        this.dogDesc = dogDesc;
    }
}