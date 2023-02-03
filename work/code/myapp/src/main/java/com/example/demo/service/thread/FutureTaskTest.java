package com.example.demo.service.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author gaonan1
 * @date 2021/7/11 18:05
 **/
public class FutureTaskTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long starttime = System.currentTimeMillis();

        //input2生成， 需要耗费3秒
        FutureTask<Integer> input2_futuretask = new FutureTask<>(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 5;
            }
        });

        new Thread(input2_futuretask).start();
        Integer integer2 = input2_futuretask.get();

        System.out.println("input2已经被执行了");

        //input1生成，需要耗费2秒
        FutureTask<Integer> input1_futuretask = new FutureTask<>(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 3;
            }
        });
        new Thread(input1_futuretask).start();

        Integer integer1 = input1_futuretask.get();
        System.out.println(algorithm(integer1, integer2));
        long endtime = System.currentTimeMillis();
        System.out.println("用时：" + (endtime - starttime));
    }

    //这是我们要执行的算法
    public static int algorithm(int input, int input2) {
        return input + input2;
    }
}
