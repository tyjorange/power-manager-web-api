package com.im.controller;

import com.im.resp.ServerResponse;
import com.im.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2019/1/27.
 */
@RestController
public class DashBoardController {
    @Autowired
    private DashBoardService dashBoardService;

    /**
     * @return
     */
    @GetMapping(value = "/dashboard/calendarData")
    public ServerResponse calendarData(String time) {
        return dashBoardService.getCalendarData(time);
    }

    /**
     * @return
     */
    @GetMapping(value = "/dashboard/pieChartData")
    public ServerResponse pieChartData(String time, String type) {
        return dashBoardService.getPieChartData(time, type);
    }
}
