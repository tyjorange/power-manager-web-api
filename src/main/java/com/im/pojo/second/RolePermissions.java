package com.im.pojo.second;

import javax.persistence.*;

@Table(name = "role_permissions")
public class RolePermissions {
    @Id
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "permissions_id")
    private Integer permissionsId;

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
}