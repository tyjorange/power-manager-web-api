package com.im.bean;

import com.im.resp.RespTableCol;

import java.util.List;

/**
 * Created by tss on 2018/11/28.
 */
public class StatisticsBean {
    private List<RespTableCol> cols;    //统计结果表头列表
    private List<GradeTime> tableData; //分级分时统计结果列表

    public List<GradeTime> getTableData() {
        return tableData;
    }

    public void setTableData(List<GradeTime> tableData) {
        this.tableData = tableData;
    }

    public List<RespTableCol> getCols() {
        return cols;
    }

    public void setCols(List<RespTableCol> cols) {
        this.cols = cols;
    }
}
