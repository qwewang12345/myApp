package com.example.demo.service.thread;

import lombok.SneakyThrows;

import java.util.concurrent.RunnableFuture;

/**
 * @author gaonan1
 * @date 2020/10/21 23:19
 **/
public class MyRunnable implements Runnable {


    @SneakyThrows
    @Override
    public void run() {
        System.out.println("这是一个runnable接口");
        Thread.sleep(3000);
    }
}
