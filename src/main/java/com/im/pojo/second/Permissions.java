package com.im.pojo.second;

import javax.persistence.*;

public class Permissions {
    @Id
    @Column(name = "permissions_id")
    private Integer permissionsId;

    @Column(name = "permissions_name")
    private String permissionsName;

    /**
     * @return permissions_id
     */
    public Integer getPermissionsId() {
        return permissionsId;
    }

    /**
     * @param permissionsId
     */
    public void setPermissionsId(Integer permissionsId) {
        this.permissionsId = permissionsId;
    }

    /**
     * @return permissions_name
     */
    public String getPermissionsName() {
        return permissionsName;
    }

    /**
     * @param permissionsName
     */
    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }
}