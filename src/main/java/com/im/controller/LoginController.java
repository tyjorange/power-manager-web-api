package com.im.controller;

import com.im.pojo.Admin;
import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.resp.RespResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import java.io.Serializable;

/**
 * Created by vostor on 2018/11/14.
 */
@RestController
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

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
            return RespResultUtil.success(RespResultEnum.AUTH_SUCCESS, sessionsId);
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
     * 登录页
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
