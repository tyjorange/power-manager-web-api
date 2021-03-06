package com.im.controller;

import com.im.bean.viewobject.RealData;
import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
import com.im.service.SignalsNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vostor on 2019/1/10.
 */
@RestController
public class SignalsNewController {
    @Autowired
    private SignalsNewService signalsNewService;

    /**
     * 获取断路器by断路器id
     *
     * @param param_1
     * @param param_2
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/get/signal_news", method = RequestMethod.GET)
    public ServerResponse getSignalNew(String param_1, String param_2) {
        if (param_1 == null || param_2 == null) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_FORMAT);
        }
        if (param_1.isEmpty() || param_2.isEmpty()) {
            return ServerResponse.success(ResponseCode.WRONG_PARAMETER_VALUE);
        }
        String[] split_1 = param_1.split(",");
        String[] split_2 = param_2.split(",");
        List<String> switchIds = Arrays.asList(split_1);
        List<String> signalsType = Arrays.asList(split_2);
        List<RealData> res = signalsNewService.findBySignalsNewTypesAndSwitchs(switchIds, signalsType);

        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, res);
    }
}
