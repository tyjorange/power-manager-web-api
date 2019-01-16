package com.im.mapper.first;

import com.im.bean.HisData;
import com.im.pojo.first.Signals;
import com.im.utils.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SignalsMapper extends MyMapper<Signals> {
    List<HisData> getSignalsByTimeAndSwitch(@Param("switchIds") List switchIds, @Param("pp") List pp, @Param("startTime") String startTime, @Param("endTime") String endTime);
}