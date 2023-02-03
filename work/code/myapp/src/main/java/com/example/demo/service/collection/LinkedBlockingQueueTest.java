package com.example.demo.service.collection;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author gaonan1
 * @date 2020/11/25 21:09
 **/
public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.put("123");
        queue.put("234");
    }
}
