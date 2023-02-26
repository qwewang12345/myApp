package com.example.demo.service.spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author gaonan1
 * @date 2021/6/17 9:40
 **/
public class JavaSPITest {

    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
