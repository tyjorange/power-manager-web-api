package com.im.pojo.second;

import javax.persistence.*;

@Table(name = "web_user_role")
public class WebUserRole {
    @Id
    private Integer id;

    @Column(name = "web_user_id")
    private Integer webUserId;

    @Column(name = "role_id")
    private Integer roleId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}