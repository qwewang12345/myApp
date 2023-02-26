package com.example.demo.service.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gaonan1
 * @date 2020/12/16 21:48
 **/
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.await();
    }
}
