package com.im.mapper;

import com.im.pojo.ApexDay;
import com.im.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface ApexDayMapper extends MyMapper<ApexDay> {

    Double getMaxSum(@Param("switchID") String switchID,@Param("signalsTypeID") String signalsTypeID,
                     @Param("startTime") String startTime,@Param("endTime") String endTime);
}