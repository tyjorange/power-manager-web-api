package com.im.resp;

/**
 * 用于HTTP返回的 封装对象
 * Created by vostor on 2018/10/26.
 */
public class RespResultUtil {
    /**
     * 正常返回结果(带结果集)
     *
     * @param respResultEnum
     * @param object
     * @param total
     * @return
     */
    public static RespResult success(RespResultEnum respResultEnum, Object object, Long total) {
        RespResult result = new RespResult();
        result.setCode(respResultEnum.getCode());
        result.setMsg(respResultEnum.getMsg());
        result.setData(object);
        result.setTotal(total);
        return result;
    }

    /**
     * 正常返回结果(单条结果集)
     *
     * @param respResultEnum
     * @return
     */
    public static RespResult success(RespResultEnum respResultEnum, Object object) {
        return success(respResultEnum, object, null);
    }

    /**
     * 正常返回结果(不带结果集)
     *
     * @param respResultEnum
     * @return
     */
    public static RespResult success(RespResultEnum respResultEnum) {
        return success(respResultEnum, null, null);
    }

    /**
     * 自定义异常
     *
     * @param respResultEnume
     * @param msg
     * @return
     */
    public static RespResult customError(RespResultEnum respResultEnume, String msg) {
        RespResult result = new RespResult();
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
    public static RespResult customError(RespResultEnum e) {
        return customError(e, null);
    }
}
