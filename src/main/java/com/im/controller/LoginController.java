package com.im.controller;

import com.im.pojo.first.Admin;
import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.resp.RespResultUtil;
import com.im.service.UserRolePermissionsService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by vostor on 2018/11/14.
 */
@RestController
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserRolePermissionsService userRolePermissionsService;

    /**
     * 登录方法
     *
     * @param webUser
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public RespResult ajaxLogin(@RequestBody @Valid Admin webUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，%s。", bindingResult.getFieldError().getDefaultMessage());
            return RespResultUtil.customError(RespResultEnum.AUTH_FAILED, message);
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(webUser.getUsername(), webUser.getPassword());
        try {
            Serializable sessionsId = subject.getSession().getId();
            subject.login(token);
            logger.warn("Session=[{}] User=[{}] isLogin=[{}]", sessionsId, webUser.getUsername(), subject.isAuthenticated());
            return RespResultUtil.success(RespResultEnum.AUTH_SUCCESS, null);
        } catch (IncorrectCredentialsException e) {
            return RespResultUtil.success(RespResultEnum.AUTH_FAILED);
        } catch (LockedAccountException e) {
            return RespResultUtil.success(RespResultEnum.AUTH_FAILED_USER_LOCK);
        } catch (AuthenticationException e) {
            return RespResultUtil.success(RespResultEnum.AUTH_FAILED_NO_USER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespResultUtil.success(RespResultEnum.AUTH_FAILED);
    }

    /**
     * 获取info
     *
     * @param token
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/auth/info", method = RequestMethod.GET)
    public RespResult ajaxLogin(@RequestParam(value = "token", required = false) String token) {
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        if (principal == null) {
            return RespResultUtil.customError(RespResultEnum.UNAUTHORIZED);
        }
        Set<String> roles = userRolePermissionsService.getRoles(principal.toString());
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", principal);
        map.put("roles", roles);
        map.put("permissions", userRolePermissionsService.getPermissions(roles));
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        logger.warn("token=[{}]", token);
        return RespResultUtil.success(RespResultEnum.QUERY_SUCCESS, map);
    }

    /**
     * 登出
     *
     * @param webUser
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/auth/logout", method = RequestMethod.GET)
    public RespResult ajaxLogout(Admin webUser) {
        Subject subject = SecurityUtils.getSubject();
        Serializable sessionsId = subject.getSession().getId();
//        UsernamePasswordToken token = new UsernamePasswordToken(webUser.getUserName(), webUser.getPassWord());
        subject.logout();
        logger.warn("Session=[{}] User=[{}] isLogin=[{}]", sessionsId, webUser.getUsername(), subject.isAuthenticated());
        return RespResultUtil.success(RespResultEnum.OUT_SUCCESS, sessionsId);
    }


    /**
     * 未登录
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/un_auth", method = RequestMethod.GET)
    public RespResult unAuth() {
        return RespResultUtil.customError(RespResultEnum.UNAUTHORIZED);
    }

    /**
     * 被踢出后跳转的页面
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/auth/kickout", method = RequestMethod.GET)
    public RespResult kickOut() {
        return RespResultUtil.customError(RespResultEnum.UNAUTHORIZED);
    }
}
