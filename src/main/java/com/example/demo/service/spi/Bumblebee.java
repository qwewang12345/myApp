package com.example.demo.service.spi;

import com.example.demo.service.spi.adaptive.FruitGranter;

/**
 * @author gaonan1
 * @date 2021/6/17 9:39
 **/
public class Bumblebee implements Robot {

    private FruitGranter fruitGranter;

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }

    public void setApple(FruitGranter fruitGranter) {
        this.fruitGranter = fruitGranter;
    }
}
