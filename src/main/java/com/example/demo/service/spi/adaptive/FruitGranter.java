package com.example.demo.service.spi.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author gaonan1
 * @date 2021/6/27 14:26
 **/
@SPI
public interface FruitGranter {

    void grant();

    @Adaptive(value = {"fruitName"})
    String watering(URL url);
}
