package com.example.demo.service.aop;

import com.example.demo.service.aop.svc.DateSvc;
import com.example.demo.service.aop.svc.TestSvc;
import com.example.demo.service.aop.svc.TestTarget;
import com.example.demo.service.collection.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Date;

/**
 * @author gaonan1
 * @date 2020/5/14
 **/
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.example.demo.service.aop")
public class Boostrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Boostrap.class);
        TestSvc svc = (TestSvc) context.getBean("testSvc");
        svc.process();
        System.out.println("==================");
        DateSvc dateSvc = (DateSvc) context.getBean("dateSvc");
        dateSvc.printDate(new Date());
        TestTarget testTarget = (TestTarget) context.getBean("testTarget");
        testTarget.sayTarget();
    }
}
