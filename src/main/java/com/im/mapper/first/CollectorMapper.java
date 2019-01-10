package com.im.mapper.first;

import com.im.pojo.first.Collector;
import com.im.utils.MyMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollectorMapper extends MyMapper<Collector> {

    List<Collector> getUsedCollector();
}