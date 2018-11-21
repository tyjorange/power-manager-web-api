package com.im.aspect;

import com.im.resp.RespResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vostor on 2018/10/26.
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //表示DogController.dogList(..)所有[dogList]参数被拦截
    //表示DogController.*(..)所有[方法]参数被拦截
    @Pointcut("execution(public * com.im.controller.*.*(..))")
    private void cutPoint() {
        //切点
    }

    /**
     * @param joinPoint
     */
    @Before("cutPoint()")
    private void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes att = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = att.getRequest();
        //url method
        logger.warn("URI=[{}] | Method=[{}]", req.getRequestURL(), req.getMethod());
        //ip
//        logger.warn("ip={}", req.getRemoteAddr());
        //获取 类名.类方法
//        logger.warn("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //获取 参数
//        logger.warn("args={}", joinPoint.getArgs());
    }

    /**
     *
     */
    @After("cutPoint()")
    private void doAfter() {
//        logger.warn("After...");
    }

    /**
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "cutPoint()")
    private void doAfterReturning(Object object) {
        if (object instanceof RespResult) {
            //获取请求后返回的内容
            RespResult respResult = ((RespResult) object);
            logger.warn("Response=[{}]", respResult);
        }
    }
}
