package com.im.mapper.first;

import com.im.pojo.first.Collector;
import com.im.utils.MyMapper;

import java.util.List;

public interface CollectorMapper extends MyMapper<Collector> {

    List<Collector> getUsedCollector();
}
