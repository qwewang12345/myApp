package com.example.demo.service.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author gaonan
 * @date 2022/5/9 下午7:53
 */
public class LockSupportTest {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        LockSupport.unpark(thread);//释放许可
        LockSupport.park();// 获取许可
        System.out.println("b");
    }
}
