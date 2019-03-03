package com.im.resp;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * HTTP 请求返回的最外层对象
 * Created by vostor on 2018/10/26.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    // 具体内容
    private T data;
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

    public void setData(T data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 正常返回结果(带结果集)
     *
     * @param responseCode
     * @param object
     * @param total
     * @return
     */
    public static <T> ServerResponse<T> success(ResponseCode responseCode, T object, Long total) {
        ServerResponse result = new ServerResponse();
        result.setCode(responseCode.getCode());
        result.setMsg(responseCode.getDesc());
        result.setData(object);
        result.setTotal(total);
        return result;
    }

    /**
     * 正常返回结果(单条结果集)
     *
     * @param responseCode
     * @return
     */
    public static ServerResponse success(ResponseCode responseCode, Object object) {
        return success(responseCode, object, null);
    }

    /**
     * 正常返回结果(不带结果集)
     *
     * @param responseCode
     * @return
     */
    public static ServerResponse success(ResponseCode responseCode) {
        return success(responseCode, null, null);
    }

    /**
     * 自定义异常
     *
     * @param respResultEnume
     * @param msg
     * @return
     */
    public static ServerResponse customError(ResponseCode respResultEnume, String msg) {
        ServerResponse result = new ServerResponse();
        result.setCode(respResultEnume.getCode());
        result.setMsg(msg);
        return result;
    }

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    public static ServerResponse customError(ResponseCode e) {
        return customError(e, e.getDesc());
    }
}
