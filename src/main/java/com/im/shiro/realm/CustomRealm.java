package com.im.shiro.realm;

import com.im.pojo.Admin;
import com.im.pojo.RolePermissions;
import com.im.pojo.UserRole;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vostor on 2018/11/14.
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RolePermissionsMapper rolePermissionsMapper;
    @Autowired
    private AdminMapper webUserMapper;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) super.getAvailablePrincipal(principalCollection);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = this.getRoles(username);
        System.out.println(roles);
        authorizationInfo.setRoles(roles);// 设置角色
        Set<String> permissions = this.getPermissions(roles);
        System.out.println(permissions);
        authorizationInfo.addStringPermissions(permissions);//设置权限
        return authorizationInfo;
    }

    /**
     * 获取用户角色
     *
     * @param username
     * @return
     */
    private Set<String> getRoles(String username) {
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName", username);
        List<UserRole> list = userRoleMapper.selectByExample(example);
        Set<String> roles = new HashSet<>();
        list.forEach(role -> roles.add(role.getRoleName()));
        return roles;
    }

    /**
     * 获取角色权限
     *
     * @param roles
     * @return
     */
    private Set<String> getPermissions(Set<String> roles) {
        Set<String> permissions = new HashSet<>();
        roles.forEach(roleName -> {
            Example example = new Example(RolePermissions.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("roleName", roleName);
            List<RolePermissions> rolePermissions = rolePermissionsMapper.selectByExample(example);
            rolePermissions.forEach(rp -> permissions.add(rp.getRolePermissions()));
        });
        return permissions;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = getPasswordByUsername(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(SALT));
        return simpleAuthenticationInfo;
    }

    /**
     * 获取用户密码
     *
     * @param username
     * @return
     */
    private String getPasswordByUsername(String username) {
        Example example = new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        List<Admin> webUsers = webUserMapper.selectByExample(example);
        if (webUsers.size() == 0) {
            throw new AuthenticationException();
        }
        return webUsers.get(0).getPassword();
    }

    private static final String SALT = "abc";
    private static final int hashIterations = 2;

    /**
     * @param args
     */
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("admin", SALT, hashIterations);//22d70c2e5b86d3c9f25735ebbabf40af
        System.out.println(md5Hash);
    }
}
