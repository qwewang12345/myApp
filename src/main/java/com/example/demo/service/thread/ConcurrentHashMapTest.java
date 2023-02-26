package com.example.demo.service.thread;

import org.apache.flink.runtime.util.ExecutorThreadFactory;
import scala.Int;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gaonan
 * @date 2022/10/21 上午10:47
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            executor.submit(() -> {
                concurrentHashMap.put(finalI, String.valueOf(finalI));
                latch.countDown();
            });
        }
        latch.await();
        System.out.println(concurrentHashMap.size());
    }
}
