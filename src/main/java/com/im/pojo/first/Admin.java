package com.im.pojo.first;

import javax.persistence.Column;
import javax.persistence.Id;

public class Admin {
    @Id
    private String id;

    private String username;

    private String password;

    @Column(name = "timeMills")
    private Long timemills;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return timeMills
     */
    public Long getTimemills() {
        return timemills;
    }

    /**
     * @param timemills
     */
    public void setTimemills(Long timemills) {
        this.timemills = timemills;
    }
}