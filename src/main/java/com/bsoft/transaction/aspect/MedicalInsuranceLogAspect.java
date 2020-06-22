package com.bsoft.transaction.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 医保处理Controller切面类
 * @author wangruix
 */
@Component
@Aspect
public class MedicalInsuranceLogAspect {


    private static final Logger logger = LoggerFactory.getLogger(MedicalInsuranceLogAspect.class);

    @Pointcut("execution(* com.bsoft.transaction.controller.MedicalInsuranceController.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        logger.info("==================前置执行=====================");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("请求来源：{}", request.getRemoteAddr());
        logger.info("请求方式：{}", request.getMethod());
        logger.info("响应方法：{}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.info("请求参数：{}", Arrays.toString(joinPoint.getArgs()));
        logger.info("==================前置执行完成==================");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void after(JoinPoint point, Object result) {
        logger.info("==================后置返回执行=====================");
        logger.info("返回数据：{}", result.toString());
        logger.info("==================后置返回执行完成==================");
    }
}
