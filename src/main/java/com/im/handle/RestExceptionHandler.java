package com.im.handle;

import java.io.IOException;

import com.im.resp.RespResult;
import com.im.resp.RespResultEnum;
import com.im.resp.RespResultUtil;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常增强，以JSON的形式返回给客服端
 * 异常增强类型：NullPointerException,RunTimeException,ClassCastException,
 * 　　　　　　　　 NoSuchMethodException,IOException,IndexOutOfBoundsException
 * 　　　　　　　　 以及springmvc自定义异常等，如下：
 * SpringMVC自定义异常对应的status code
 * Exception                       HTTP Status Code
 * ConversionNotSupportedException         500 (Internal Server Error)
 * HttpMessageNotWritableException         500 (Internal Server Error)
 * HttpMediaTypeNotSupportedException      415 (Unsupported Media Type)
 * HttpMediaTypeNotAcceptableException     406 (Not Acceptable)
 * HttpRequestMethodNotSupportedException  405 (Method Not Allowed)
 * NoSuchRequestHandlingMethodException    404 (Not Found)
 * TypeMismatchException                   400 (Bad Request)
 * HttpMessageNotReadableException         400 (Bad Request)
 * MissingServletRequestParameterException 400 (Bad Request)
 */
@ControllerAdvice
public class RestExceptionHandler {
    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public RespResult runtimeExceptionHandler(RuntimeException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public RespResult nullPointerExceptionHandler(NullPointerException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public RespResult classCastExceptionHandler(ClassCastException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public RespResult iOExceptionHandler(IOException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public RespResult noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public RespResult indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public RespResult requestNotReadable(HttpMessageNotReadableException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public RespResult requestTypeMismatch(TypeMismatchException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public RespResult requestMissingServletRequest(MissingServletRequestParameterException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public RespResult request405(HttpRequestMethodNotSupportedException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public RespResult request406(HttpMediaTypeNotAcceptableException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseBody
    public RespResult server500(RuntimeException ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //其他异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RespResult handle(Exception ex) {
        return RespResultUtil.customError(RespResultEnum.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}