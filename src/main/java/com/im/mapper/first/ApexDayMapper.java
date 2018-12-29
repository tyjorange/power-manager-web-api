package com.im.mapper.first;

import com.im.pojo.first.ApexDay;
import com.im.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface ApexDayMapper extends MyMapper<ApexDay> {

    Double getMaxSum(@Param("switchID") String switchID, @Param("signalsTypeID") String signalsTypeID,
                     @Param("startTime") String startTime, @Param("endTime") String endTime);
}