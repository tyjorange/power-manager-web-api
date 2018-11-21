package com.im.exception;

import com.im.resp.RespResultEnum;

/**
 * 自定义异常
 * Created by vostor on 2018/10/26.
 */
public class CustomException extends RuntimeException {
    private Integer code;

    public CustomException(RespResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

}
