package com.im.controller;

import com.im.pojo.first.Switch;
import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.resp.RespResultUtil;
import com.im.service.GradeTimeService;
import com.im.service.SwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * 分级分时统计控制器
 * Created by tss on 2018/11/27.
 */
@RestController
public class GradeTimeController {

    @Autowired
    private GradeTimeService gradeTimeService;
    @Autowired
    private SwitchService switchService;

    @CrossOrigin
    @GetMapping(value = "/getSwitchs")
    public RespResult getSwitchs() {
        List<Switch> switches = switchService.findAll();
        return RespResultUtil.success(RespResultEnum.QUERY_SUCCESS, switches);
    }

    @CrossOrigin
    @PostMapping(value = "/gradeTimeStatistics")
    public RespResult gradeTimeStatistics(@RequestParam(value = "switchID", required = false) String switchID,
                                          @RequestParam(value = "time", required = false) String time,
                                          @RequestParam(value = "timeType", required = false) Integer timeType) throws ParseException {
        return gradeTimeService.gradeTimeStatistics(switchID, time, timeType);
    }
}
