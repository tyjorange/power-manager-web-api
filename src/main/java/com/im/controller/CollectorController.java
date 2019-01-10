package com.im.controller;

import com.im.bean.ElCascader;
import com.im.pojo.first.Collector;
import com.im.pojo.first.Fsu;
import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.resp.RespResultUtil;
import com.im.service.CollectorService;
import com.im.service.FsuService;
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
 * 集中器管理
 * Created by vostor on 2019/1/9.
 */
@RestController
public class CollectorController {
    private final static Logger logger = LoggerFactory.getLogger(CollectorController.class);
    @Autowired
    private FsuService fsuService;
    @Autowired
    private CollectorService collectorService;

    /**
     * 获取fus&集中器 二级菜单
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/get/fsu/collectors", method = RequestMethod.GET)
    public RespResult getCollectorSwitch() {
        List<ElCascader> list_1 = new ArrayList<>();
        List<Fsu> fsus = fsuService.findAll();
        fsus.forEach(fsu -> {
            ElCascader el_1 = new ElCascader();
            el_1.setValue(fsu.getFsuid());
            el_1.setLabel(fsu.getFsuname());
            List<Collector> collectors = collectorService.findByFsuID(fsu.getFsuid());
            List<ElCascader> list_2 = new ArrayList<>();
            collectors.forEach(collector -> {
                ElCascader el_2 = new ElCascader();
                el_2.setValue(collector.getCollectorid());
                el_2.setLabel(collector.getName());
                list_2.add(el_2);
            });
            el_1.setChildren(list_2);
            list_1.add(el_1);
        });
        return RespResultUtil.success(RespResultEnum.QUERY_SUCCESS, list_1);
    }

}
