package com.example.demo.service.aop.svc;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * @author gaonan1
 * @date 2021/5/19 11:10
 **/
@Service("testTarget")
public class TestTarget {

    public void sayTarget() {
        System.out.println("testTarget is working");
        TestTarget tt = (TestTarget) AopContext.currentProxy();
        tt.sayProtected();
    }

    protected void sayProtected() {
        System.out.println("protected is invoke");
    }
}
