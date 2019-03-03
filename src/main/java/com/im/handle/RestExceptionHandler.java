package com.im.handle;

import java.io.IOException;

import com.im.resp.ServerResponse;
import com.im.resp.ResponseCode;
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
    public ServerResponse runtimeExceptionHandler(RuntimeException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ServerResponse nullPointerExceptionHandler(NullPointerException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public ServerResponse classCastExceptionHandler(ClassCastException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public ServerResponse iOExceptionHandler(IOException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public ServerResponse noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public ServerResponse indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ServerResponse requestNotReadable(HttpMessageNotReadableException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public ServerResponse requestTypeMismatch(TypeMismatchException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public ServerResponse requestMissingServletRequest(MissingServletRequestParameterException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public ServerResponse request405(HttpRequestMethodNotSupportedException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public ServerResponse request406(HttpMediaTypeNotAcceptableException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseBody
    public ServerResponse server500(RuntimeException ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    //其他异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ServerResponse handle(Exception ex) {
        return ServerResponse.customError(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}