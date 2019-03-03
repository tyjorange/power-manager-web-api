package com.im.controller;

import com.github.pagehelper.PageInfo;
import com.im.bean.viewobject.HisData;
import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
import com.im.service.SignalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * 历史信号表
 * Created by vostor on 2019/1/14.
 */
@RestController
public class SignalsController {
    @Autowired
    private SignalsService signalsService;

    /**
     * 获取断路器by断路器id
     *
     * @param param_1
     * @param param_2
     * @param startTime
     * @param endTime
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/get/signal_his", method = RequestMethod.GET)
    public ServerResponse getSignalHis(String param_1, String param_2, String startTime, String endTime, Integer page, Integer limit) throws ParseException {
        if (param_1 == null || param_2 == null || startTime == null || endTime == null) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_FORMAT);
        }
        if (param_1.isEmpty() || param_2.isEmpty()) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_VALUE);
        }
        String[] split_1 = param_1.split(",");
        String[] split_2 = param_2.split(",");
        List<String> switchIds = Arrays.asList(split_1);
        List<String> signalsType = Arrays.asList(split_2);
        PageInfo<HisData> pageInfo = signalsService.findBySignalsTypesAndSwitchs(switchIds, signalsType, startTime, endTime, page, limit);
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 获取断路器by断路器id
     *
     * @param param_1
     * @param param_2
     * @param startTime
     * @param endTime
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/get/point_used", method = RequestMethod.GET)
    public ServerResponse getPointUsed(String param_1, String param_2, String startTime, String endTime) throws ParseException {
        if (param_1 == null || param_2 == null || startTime == null || endTime == null) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_FORMAT);
        }
        if (param_1.isEmpty() || param_2.isEmpty()) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_VALUE);
        }
//        String[] split_1 = param_1.split(",");
//        String[] split_2 = param_2.split(",");
//        List<String> switchIds = Arrays.asList(split_1);
//        List<String> signalsType = Arrays.asList(split_2);
//        PageInfo<HisData> pageInfo = signalsService.findBySignalsTypesAndSwitchs(switchIds, signalsType, startTime, endTime, page, limit);
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS);
    }
}
