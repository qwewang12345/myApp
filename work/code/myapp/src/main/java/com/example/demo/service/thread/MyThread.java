package com.example.demo.service.thread;

import lombok.SneakyThrows;

/**
 * @author gaonan1
 * @date 2020/9/28 22:42
 **/
public class MyThread extends Thread {

    private static Integer num = 0;

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(30000);
        System.out.println(String.format("thread %d start", num++));
    }
}