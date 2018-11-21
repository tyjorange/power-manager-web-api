package com.im.pojo;

import javax.persistence.*;

@Table(name = "user_role")
public class UserRole {
    @Column(name = "user_name")
    private String userName;

    @Column(name = "role_name")
    private String roleName;

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}