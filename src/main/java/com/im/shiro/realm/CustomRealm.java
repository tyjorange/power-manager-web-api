package com.im.shiro.realm;

import com.im.service.UserRolePermissionsService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 权限认证
 * Created by vostor on 2018/11/14.
 */
public class CustomRealm extends AuthorizingRealm {
    private final static Logger logger = LoggerFactory.getLogger(CustomRealm.class);
    @Autowired
    private UserRolePermissionsService userRolePermissionsService;

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
        String password = userRolePermissionsService.getPasswordByUsername(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(SALT));
        return simpleAuthenticationInfo;
    }

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
        Set<String> roles = userRolePermissionsService.getRoles(username);
        authorizationInfo.setRoles(roles);// 设置角色
        logger.warn("角色=[{}]", roles.toString());
        Set<String> permissions = userRolePermissionsService.getPermissions(roles);
        authorizationInfo.addStringPermissions(permissions);//设置权限
        logger.warn("权限=[{}]", permissions.toString());
        return authorizationInfo;
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
