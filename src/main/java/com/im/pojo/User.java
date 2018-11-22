package com.im.pojo;

import javax.persistence.*;

public class User {
    @Id
    private String id;

    private String username;

    private String password;

    @Column(name = "timeMills")
    private Long timemills;

    @Column(name = "nickName")
    private String nickname;

    @Column(name = "headImg")
    private String headimg;

    private String phone;

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

    /**
     * @return nickName
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return headImg
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * @param headimg
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}