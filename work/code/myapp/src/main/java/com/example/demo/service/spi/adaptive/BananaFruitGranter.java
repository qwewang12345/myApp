package com.example.demo.service.spi.adaptive;

import org.apache.dubbo.common.URL;

/**
 * @author gaonan1
 * @date 2021/6/27 14:53
 **/
public class BananaFruitGranter implements FruitGranter {


    @Override
    public void grant() {
        System.out.println("this is an banana");
    }

    @Override
    public String watering(URL url) {
        System.out.println("watering banana");
        return "banana";
    }
}
