package com.example.demo.service.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author gaonan1
 * @date 2021/1/4 22:21
 **/
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(10);

        for (int i = 0; i < 10; ++i) // create and start threads
        {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        System.out.println("before start signal");            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        System.out.println("after start signal");
        doneSignal.await();           // wait for all to finish
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {
        } // return;
    }

    void doWork() {
        System.out.println("我是worker的dowork");
    }
}
