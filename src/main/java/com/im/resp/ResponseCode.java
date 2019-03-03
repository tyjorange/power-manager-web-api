package com.im.resp;

/**
 * 返回码
 * Created by vostor on 2018/10/26.
 */
public enum ResponseCode {
    QUERY_SUCCESS(0, "查询成功"),
    QUERY_FAILED(1, "查询失败"),
    EMPTY_RESULT(2, "无结果"),
    ADD_UPDATE_SUCCESS(20, "添加/修改成功"),
    ADD_UPDATE_FAILED(21, "添加/修改失败"),
    ADD_UPDATE_DUPLICATE(22, "添加/修改失败-编码重复"),
    DEL_SUCCESS(30, "删除成功"),
    DEL_FAILED(31, "删除失败"),
    WRONG_PARAMETER_FORMAT(4, "参数格式错误"),
    WRONG_PARAMETER_VALUE(5, "参数值错误"),
    DATABASE_EXCEPTION(6, "数据库操作失败"),
    AUTH_SUCCESS(200, "认证成功"),
    AUTH_FAILED(401, "认证失败 密码错误"),
    AUTH_FAILED_NO_USER(401, "认证失败 该用户不存在"),
    AUTH_FAILED_USER_LOCK(401, "认证失败 该用户已被冻结"),
    OUT_SUCCESS(100, "登出成功"),
    UNAUTHORIZED(403, "未认证（签名错误）"),
    NOT_FOUND(404, "接口不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private Integer code;
    private String desc;

    ResponseCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
