package com.im.controller;

import com.im.pojo.first.Switch;
import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.resp.RespResultUtil;
import com.im.service.CollectorService;
import com.im.service.SwitchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
     * 获取断路器by集中器id
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/get/switchs", method = RequestMethod.GET)
    public RespResult getSwitch(String collectorId) {
        if (collectorId == null) {
            return RespResultUtil.success(RespResultEnum.WRONG_PARAMETER_FORMAT);
        }
        if (collectorId.isEmpty()) {
            return RespResultUtil.success(RespResultEnum.WRONG_PARAMETER_VALUE);
        }
        List<Switch> list_1 = switchService.findByCollectorID(collectorId);
        list_1.forEach(aSwitch -> aSwitch.setCollectorid(collectorService.findByID(aSwitch.getCollectorid()).getName()));
        return RespResultUtil.success(RespResultEnum.QUERY_SUCCESS, list_1);
    }
}
