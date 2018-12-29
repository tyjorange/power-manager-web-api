package com.im.pojo.second;

import javax.persistence.*;

@Table(name = "web_user")
public class WebUser {
    @Id
    @Column(name = "web_user_id")
    private Integer webUserId;

    @Column(name = "web_user_name")
    private String webUserName;

    @Column(name = "web_user_password")
    private String webUserPassword;

    @Column(name = "web_user_avatar")
    private String webUserAvatar;

    /**
     * @return web_user_id
     */
    public Integer getWebUserId() {
        return webUserId;
    }

    /**
     * @param webUserId
     */
    public void setWebUserId(Integer webUserId) {
        this.webUserId = webUserId;
    }

    /**
     * @return web_user_name
     */
    public String getWebUserName() {
        return webUserName;
    }

    /**
     * @param webUserName
     */
    public void setWebUserName(String webUserName) {
        this.webUserName = webUserName;
    }

    /**
     * @return web_user_password
     */
    public String getWebUserPassword() {
        return webUserPassword;
    }

    /**
     * @param webUserPassword
     */
    public void setWebUserPassword(String webUserPassword) {
        this.webUserPassword = webUserPassword;
    }

    /**
     * @return web_user_avatar
     */
    public String getWebUserAvatar() {
        return webUserAvatar;
    }

    /**
     * @param webUserAvatar
     */
    public void setWebUserAvatar(String webUserAvatar) {
        this.webUserAvatar = webUserAvatar;
    }
}