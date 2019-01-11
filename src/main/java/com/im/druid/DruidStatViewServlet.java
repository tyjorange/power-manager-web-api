package com.im.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * druid监控视图配置
 * Created by vostor on 2019/1/10.
 */
@WebServlet(urlPatterns = "/druid/*", initParams = {
        @WebInitParam(name = "allow", value = ""),// IP白名单 (没有配置或者为空，则允许所有访问)
        @WebInitParam(name = "deny", value = ""),// IP黑名单 (存在共同时，deny优先于allow)
        @WebInitParam(name = "loginUsername", value = "ddd"),// 用户名
        @WebInitParam(name = "loginPassword", value = "ddd"),// 密码
        @WebInitParam(name = "resetEnable", value = "true")// 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
}
