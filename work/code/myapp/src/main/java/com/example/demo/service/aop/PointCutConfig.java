package com.example.demo.service.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author gaonan1
 * @date 2020/5/14
 **/
@Aspect
@Component
public class PointCutConfig {

    @Pointcut("within(com.example.demo.service.aop.svc..*)")
    public void inSvcLayer() {

    }

    @Pointcut("execution(* com.example.demo.service.aop.svc.*.*(..))")
    public void testSvcProcess() {

    }
}
