package com.im.service;

import com.im.mapper.second.*;
import com.im.pojo.second.*;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vostor on 2018/12/29.
 */
@Service
public class UserRolePermissionsService {
    @Autowired
    private WebUserRoleMapper userRoleMapper;
    @Autowired
    private RolePermissionsMapper rolePermissionsMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private WebUserMapper webUserMapper;
    @Autowired
    private PermissionsMapper permissionsMapper;

    /**
     * 获取用户密码
     *
     * @param webUsername
     * @return
     */
    public String getPasswordByUsername(String webUsername) {
        Example example = new Example(WebUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("webUserName", webUsername);
        List<WebUser> webUsers = webUserMapper.selectByExample(example);
        if (webUsers.size() == 0) {
            throw new AuthenticationException();
        }
        return webUsers.get(0).getWebUserPassword();
    }

    /**
     * 获取用户角色
     *
     * @param webUserName
     * @return
     */
    public Set<String> getRoles(String webUserName) {
        Example example = new Example(WebUserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("webUserId", this.getWebUserId(webUserName));
        List<WebUserRole> list = userRoleMapper.selectByExample(example);
        Set<String> roles = new HashSet<>();
        list.forEach(u_r -> roles.add(this.getRoleName(u_r.getRoleId())));
        return roles;
    }

    /**
     * 获取角色权限
     *
     * @param roles
     * @return
     */
    public Set<String> getPermissions(Set<String> roles) {
        Set<String> permissions = new HashSet<>();
        roles.forEach(roleName -> {
            Example example = new Example(RolePermissions.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("roleId", this.getRoleId(roleName));
            List<RolePermissions> rolePermissions = rolePermissionsMapper.selectByExample(example);
            rolePermissions.forEach(rp -> permissions.add(this.getPermissionsName(rp.getPermissionsId())));
        });
        return permissions;
    }

    /**
     * 根据id获取权限名
     *
     * @param permissionsId
     * @return
     */
    private String getPermissionsName(Integer permissionsId) {
        Permissions permissions = permissionsMapper.selectByPrimaryKey(permissionsId);
        return permissions.getPermissionsName();
    }

    /**
     * 根据用户名获取id
     *
     * @param webUserName
     * @return
     */
    private Integer getWebUserId(String webUserName) {
        Example example = new Example(WebUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("webUserName", webUserName);
        List<WebUser> webUsers = webUserMapper.selectByExample(example);
        return webUsers.get(0).getWebUserId();
    }

    /**
     * 根据id获取角色名
     *
     * @param roleId
     * @return
     */
    private String getRoleName(Integer roleId) {
        Role role = roleMapper.selectByPrimaryKey(roleId);
        return role.getRoleName();
    }

    /**
     * 根据角色名称获取id
     *
     * @param roleName
     * @return
     */
    private Integer getRoleId(String roleName) {
        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleName", roleName);
        List<Role> webUsers = roleMapper.selectByExample(example);
        return webUsers.get(0).getRoleId();
    }
}
