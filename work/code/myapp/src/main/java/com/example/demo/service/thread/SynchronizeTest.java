package com.example.demo.service.thread;

/**
 * @author gaonan1
 * @date 2020/12/2 21:51
 **/


public class SynchronizeTest implements Runnable {
    //共享资源(临界资源)
    static int i = 0;

    /**
     * synchronized 修饰实例方法
     */
    public static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizeTest instance = new SynchronizeTest();
        Thread t1 = new Thread(new SynchronizeTest());
        Thread t2 = new Thread(new SynchronizeTest());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
        Object a = new Object();
    }
    /**
     * 输出结果:
     * 2000000
     */
}


