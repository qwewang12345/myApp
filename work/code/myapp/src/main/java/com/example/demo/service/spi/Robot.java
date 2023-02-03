package com.example.demo.service.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author gaonan1
 * @date 2021/6/17 9:37
 **/
@SPI
public interface Robot {

    void sayHello();
}
