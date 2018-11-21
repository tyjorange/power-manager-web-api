package com.im.resp;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * HTTP 请求返回的最外层对象
 * Created by vostor on 2018/10/26.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespResult {
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    // 具体内容
    private Object data;
    //数据总数
    private Long total;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "RespResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", total=" + total +
                '}';
    }
}
