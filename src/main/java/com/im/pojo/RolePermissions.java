package com.im.pojo;

import javax.persistence.*;

@Table(name = "role_permissions")
public class RolePermissions {
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_permissions")
    private String rolePermissions;

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

    /**
     * @return role_permissions
     */
    public String getRolePermissions() {
        return rolePermissions;
    }

    /**
     * @param rolePermissions
     */
    public void setRolePermissions(String rolePermissions) {
        this.rolePermissions = rolePermissions;
    }
}