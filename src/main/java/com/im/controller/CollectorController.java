package com.im.controller;

import com.im.bean.viewobject.ElCascader;
import com.im.bean.viewobject.ElTree;
import com.im.pojo.first.Collector;
import com.im.pojo.first.Fsu;
import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
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
    public ServerResponse getCollectorSwitch() {
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
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, list_1);
    }

    /**
     * 获取fus&集中器 树形结构
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/get/fsu/collectorTree", method = RequestMethod.GET)
    public ServerResponse getCollectorTree() {
        List<ElTree> list_1 = new ArrayList<>();
        List<Fsu> fsus = fsuService.findAll();
        fsus.forEach(fsu -> {
            ElTree el_1 = new ElTree();
            el_1.setId(fsu.getFsuid());
            el_1.setLabel(fsu.getFsuname());
            List<Collector> collectors = collectorService.findByFsuID(fsu.getFsuid());
            List<ElTree> list_2 = new ArrayList<>();
            collectors.forEach(collector -> {
                ElTree el_2 = new ElTree();
                el_2.setId(collector.getCollectorid());
                el_2.setLabel(collector.getName());
                list_2.add(el_2);
            });
            el_1.setChildren(list_2);
            list_1.add(el_1);
        });
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, list_1);
    }

    /**
     * 获取所有集中器列表
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/get/collectors", method = RequestMethod.GET)
    public ServerResponse getCollectors(){
        return ServerResponse.success(ResponseCode.QUERY_SUCCESS, collectorService.findAll());
    }

}
