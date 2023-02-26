package com.example.demo.service.structure;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author gaonan
 * @date 2022/10/13 下午3:41
 */
public class PressTest {

    public static final Object lock = new Object();
    public static AtomicInteger successCount = new AtomicInteger();
    public static AtomicInteger failCount = new AtomicInteger();
    public static AtomicLong totalTime = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {
        pressTest(100, 10000);
    }

    public static void pressTest(int threadNum, int pressCount) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                threadNum,
                threadNum,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(pressCount),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < pressCount; i++) {
            executor.submit(() -> {
                long startTime = System.currentTimeMillis();
                boolean res = false;
                try {
                    res = testMethod();
                } catch (InterruptedException e) {
                    System.out.println("进入到异常的情况");
                    e.printStackTrace();
                }
                long endTime = System.currentTimeMillis();
                if (res) {
                    successCount.incrementAndGet();
                } else {
                    failCount.incrementAndGet();
                }
                totalTime.addAndGet(endTime - startTime);
            });
        }
        Thread.sleep(3000);
        System.out.println(String.format("成功次数，successCount=%d", successCount.get()));
        System.out.println(String.format("失败次数，failCount=%d", failCount.get()));
        System.out.println(String.format("平均耗时，averageTime=%d", totalTime.get() / (long) pressCount));
    }

    public static boolean testMethod() throws InterruptedException {
        Thread.sleep(1);
        return true;
    }
}
