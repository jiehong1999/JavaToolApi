package com.baidu.fanyi.fanyi.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
*
打印service目录的日志文件
 *
 */
@Component
@Aspect
public class LogAspect {
    private static final Log LOG = LogFactory.getLog(LogAspect.class);
    @Pointcut("execution(* com.baidu.fanyi.fanyi.service..*.*(..))")
    public void logPointcut(){}
    @org.aspectj.lang.annotation.Around("logPointcut()")

    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
//    	 LOG.debug("logPointcut " + joinPoint + "\t");
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            LOG.debug("执行方法" + joinPoint.getSignature()+ "消耗时长: " + (end - start) + " ms!");
            return result;

        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            LOG.error("+++++around " + joinPoint + "消耗时长 : " + (end - start) + "异常信息: " + e.getMessage());
            throw e;
        }

    }
}
