package com.im.controller;

import com.im.pojo.first.Admin;
import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
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
    public ServerResponse ajaxLogin(@RequestBody @Valid Admin webUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，%s。", bindingResult.getFieldError().getDefaultMessage());
            return ServerResponse.customError(ResponseCode.AUTH_FAILED, message);
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(webUser.getUsername(), webUser.getPassword());
        try {
            Serializable sessionsId = subject.getSession().getId();
            subject.login(token);
            logger.warn("Session=[{}] User=[{}] isLogin=[{}]", sessionsId, webUser.getUsername(), subject.isAuthenticated());
            return ServerResponse.success(ResponseCode.AUTH_SUCCESS, null);
        } catch (IncorrectCredentialsException e) {
            return ServerResponse.success(ResponseCode.AUTH_FAILED);
        } catch (LockedAccountException e) {
            return ServerResponse.success(ResponseCode.AUTH_FAILED_USER_LOCK);
        } catch (AuthenticationException e) {
            return ServerResponse.success(ResponseCode.AUTH_FAILED_NO_USER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServerResponse.success(ResponseCode.AUTH_FAILED);
    }

    /**
     * 获取info
     *
     * @param token
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/auth/info", method = RequestMethod.GET)
    public ServerResponse getInfo(@RequestParam(value = "token", required = false) String token) {
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        if (principal == null) {
            return ServerResponse.customError(ResponseCode.UNAUTHORIZED);
        }
        Set<String> roles = userRolePermissionsService.getRoles(principal.toString());
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", principal);
        map.put("roles", roles);
        map.put("permissions", userRolePermissionsService.getPermissions(roles));
        map.put("avatar", userRolePermissionsService.getAvatarByUsername(principal.toString()));
        logger.warn("token=[{}]", token);
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, map);
    }

    /**
     * 登出
     *
     * @param webUser
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/auth/logout", method = RequestMethod.GET)
    public ServerResponse ajaxLogout(Admin webUser) {
        Subject subject = SecurityUtils.getSubject();
        Serializable sessionsId = subject.getSession().getId();
//        UsernamePasswordToken token = new UsernamePasswordToken(webUser.getUserName(), webUser.getPassWord());
        subject.logout();
        logger.warn("Session=[{}] User=[{}] isLogin=[{}]", sessionsId, webUser.getUsername(), subject.isAuthenticated());
        return ServerResponse.success(ResponseCode.OUT_SUCCESS, sessionsId);
    }


    /**
     * 未登录
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/un_auth", method = RequestMethod.GET)
    public ServerResponse unAuth() {
        return ServerResponse.customError(ResponseCode.UNAUTHORIZED);
    }

    /**
     * 被踢出后跳转的页面
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/auth/kickout", method = RequestMethod.GET)
    public ServerResponse kickOut() {
        return ServerResponse.customError(ResponseCode.UNAUTHORIZED);
    }
}
