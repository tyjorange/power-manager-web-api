package com.im.controller;

import com.im.bean.viewobject.SwitchBean;
import com.im.pojo.first.Switch;
import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
import com.im.service.CollectorService;
import com.im.service.SwitchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 断路器
 * Created by vostor on 2019/1/9.
 */
@RestController
public class SwitchController {
    private final static Logger logger = LoggerFactory.getLogger(SwitchController.class);
    @Autowired
    private SwitchService switchService;
    @Autowired
    private CollectorService collectorService;

    /**
     * 获取所有断路器信息
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/get/allSwitchs", method = RequestMethod.GET)
    public ServerResponse getAllSwitchs() {
        List<Switch> list_1 = switchService.findAll();
        List<SwitchBean> switchBeans = new ArrayList<SwitchBean>();
        list_1.forEach(aSwitch -> switchBeans.add(new SwitchBean(aSwitch)));
        switchBeans.forEach(bean -> {
            bean.setCollectorName(collectorService.findByID(bean.getCollectorid()).getName());
            bean.setCollectorCode(collectorService.findByID(bean.getCollectorid()).getCode());
        });
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, switchBeans);
    }

    /**
     * 获取断路器by集中器id
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/get/switchs", method = RequestMethod.GET)
    public ServerResponse getSwitch(String collectorId) {
        if (collectorId == null) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_FORMAT);
        }
        if (collectorId.isEmpty()) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_VALUE);
        }
        List<Switch> list_1 = switchService.findByCollectorID(collectorId);
        list_1.forEach(aSwitch -> aSwitch.setCollectorid(collectorService.findByID(aSwitch.getCollectorid()).getName()));
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, list_1);
    }

    @CrossOrigin
    @RequestMapping(value = "/get/collector_switchs", method = RequestMethod.GET)
    public ServerResponse getSwitchs(String collectorId) {
        if (collectorId == null) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_FORMAT);
        }
        if (collectorId.isEmpty()) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_VALUE);
        }
        List<SwitchBean> switchBeans = new ArrayList<SwitchBean>();
        List<Switch> list_1 = switchService.findByCollectorID(collectorId);
        list_1.forEach(aSwitch -> switchBeans.add(new SwitchBean(aSwitch)));
        switchBeans.forEach(bean -> {
            bean.setCollectorName(collectorService.findByID(bean.getCollectorid()).getName());
            bean.setCollectorCode(collectorService.findByID(bean.getCollectorid()).getCode());
        });
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, switchBeans);
    }
}
