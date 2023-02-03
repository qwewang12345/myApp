package com.example.demo.service.spi;

import org.apache.dubbo.common.extension.Adaptive;

/**
 * @author gaonan1
 * @date 2021/6/27 13:34
 **/
@Adaptive
public class AdaptiveTest1 implements Robot {


    @Override
    public void sayHello() {
        System.out.println("hello, I am adaptive1");
    }
}
