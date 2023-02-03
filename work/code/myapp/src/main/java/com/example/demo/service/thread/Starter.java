package com.example.demo.service.thread;

/**
 * @author gaonan1
 * @date 2020/9/28 22:56
 **/
public class Starter {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
        myThread1.interrupt();
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        thread.join();
        System.out.println("I am over");
    }
}
