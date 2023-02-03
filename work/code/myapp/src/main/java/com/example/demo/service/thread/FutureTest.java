package com.example.demo.service.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author gaonan1
 * @date 2020/10/21 22:34
 **/
public class FutureTest {

    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(3000);
            return input * input;
        });
    }

    private static void futureListTest() throws InterruptedException, ExecutionException {
        Callable<Long> callable = () -> {
            long start = System.currentTimeMillis();
            Thread.sleep(100);
            long end = System.currentTimeMillis();

            long seed = end - start;
            System.out.println("seed=" + seed);

            return seed;
        };

        List<Callable<Long>> tasks = new ArrayList<>();
        tasks.add(callable);
        tasks.add(callable);
        tasks.add(callable);
        tasks.add(callable);
        tasks.add(callable);
        tasks.add(callable);
        tasks.add(callable);
        tasks.add(callable);
        tasks.add(callable);
        tasks.add(callable);

        int poolSize = Runtime.getRuntime().availableProcessors();
        System.out.println("poolSize=" + poolSize);
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        List<Future<Long>> futures = executorService.invokeAll(tasks);

        long result = 0;
        for (Future<Long> future : futures) {
            result += future.get();
        }
        System.out.println("result=" + result);
        executorService.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       Future<Integer> future = calculate(40);
       System.out.println("111");
       System.out.println("isDone:" + future.isDone());
       future.cancel(true);
       System.out.println("isCancelled:" + future.isCancelled());

       futureListTest();
    }
}
