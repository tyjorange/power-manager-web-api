package com.im.mapper.first;

import com.im.bean.viewobject.GradeSubentry;
import com.im.pojo.first.SignalHour;
import com.im.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface SignalHourMapper extends MyMapper<SignalHour> {

    //分级分项统计
    GradeSubentry gradeSubentry(@Param("startTime") String startTime,@Param("endTime") String endTime,
                                @Param("collectorID") String collectorID);

    //获取日用电量
    Double getSignalDay(@Param("queryTime") String queryTime,@Param("collectorID") String collectorID);

    //获取月用电量
    Double getSignalMonth(@Param("startTime") String startTime,@Param("endTime") String endTime,
                          @Param("collectorID") String collectorID);
}