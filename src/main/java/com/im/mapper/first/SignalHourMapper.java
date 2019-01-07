package com.im.mapper.first;

import com.im.bean.GradeSubentry;
import com.im.pojo.first.SignalHour;
import com.im.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface SignalHourMapper extends MyMapper<SignalHour> {

    GradeSubentry gradeSubentry(@Param("startTime") String startTime,@Param("endTime") String endTime,
                                @Param("collectorID") String collectorID);
}