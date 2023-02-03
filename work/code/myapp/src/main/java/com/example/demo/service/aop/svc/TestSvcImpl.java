package com.example.demo.service.aop.svc;

import com.example.demo.service.aop.svc.TestSvc;
import org.springframework.stereotype.Service;

/**
 * @author gaonan1
 * @date 2020/5/14
 **/
@Service("testSvc")
public class TestSvcImpl implements TestSvc {

    @Override
    public void process() {
        System.out.println("test svc is working");
    }
}
