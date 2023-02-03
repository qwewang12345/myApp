package com.example.demo.service.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gaonan1
 * @date 2020/10/28 20:15
 **/
public class VolatileTest {

    private static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        incrByPool();
    }

    private static void incrByThread() throws InterruptedException {
        for (int j = 0; j < 10; j++) {
            new Thread() {
                @Override
                public void run() {
                    for (int m = 0; m < 1000; m++) {
                        i++;
                    }
                }
            }.start();
        }
        Thread.sleep(3000);
        System.out.println("最终的i为" + i);
    }

    private static void incrByPool() throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        final CountDownLatch count = new CountDownLatch(10);
        for (int j = 0; j < 10; j++) {
            threadPool.submit(() -> {
                for (int m = 0; m < 1000; m++) {
                    i++;
                }
                count.countDown();
            });
            System.out.println("j的值为" + j);
        }
        count.await();
        System.out.println("i的值为" + i);
        Map<String, String> map = new HashMap<>(10);
    }
}
