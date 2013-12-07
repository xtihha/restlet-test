package com.xtihha.study.restlet.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: zhangxiaohu
 * Date: 13-12-7
 * Time: 下午8:56
 */
@Aspect
public class SpanNameAop {
    Logger logger = LoggerFactory.getLogger(SpanNameAop.class);

    //@After(value = "execution(* com.xtihha.study.restlet.resource.StudentResource.get(..))")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("{}", joinPoint.getClass());
        logger.info("{}", joinPoint.getTarget().getClass());
    }

    //@Around(value = "execution(* com.xtihha.study.restlet.manager.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("do after in joinpoint");
    }
}
