package com.im.controller;

import com.im.pojo.first.Collector;
import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
import com.im.service.CollectorService;
import com.im.service.GradeSubentryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * 分级分项统计
 * Created by tss on 2018/11/30.
 */
@RestController
public class GradeSubentryController {

    @Autowired
    private GradeSubentryService gradeSubentryService;
    @Autowired
    private CollectorService collectorService;

    @CrossOrigin
    @PostMapping("/statistics/gradeSubentry")
    public ServerResponse gradeSubentry(@RequestParam(value = "collectorID", required = false) String collectorID,
                                        @RequestParam(value = "startTime", required = false) String startTime,
                                        @RequestParam(value = "endTime", required = false) String endTime,
                                        @RequestParam(value = "timeType", required = false) Integer timeType) throws ParseException {
        return gradeSubentryService.gradeSubentry(collectorID, startTime, endTime, timeType);
    }


    @CrossOrigin
    @GetMapping("/getCollector")
    public ServerResponse getCollector(){
        List<Collector> collectors = collectorService.findAll();
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, collectors);
    }
}
