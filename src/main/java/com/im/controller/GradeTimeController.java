package com.im.controller;

import com.im.pojo.first.Switch;
import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
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
    @GetMapping(value = "/getSignalNew")
    public ServerResponse getSwitchs() {
        List<Switch> switches = switchService.findAll();
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, switches);
    }

    @CrossOrigin
    @PostMapping(value = "/statistics/gradeTime")
    public ServerResponse gradeTime(@RequestParam(value = "collectorID", required = false) String collectorID,
                                    @RequestParam(value = "time", required = false) String time,
                                    @RequestParam(value = "timeType", required = false) Integer timeType) throws ParseException {
        return gradeTimeService.gradeTime(collectorID, time, timeType);
    }
}
