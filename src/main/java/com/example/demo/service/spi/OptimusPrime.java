package com.example.demo.service.spi;

/**
 * @author gaonan1
 * @date 2021/6/17 9:38
 **/
public class OptimusPrime implements Robot {

    private Student student;

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }
}
