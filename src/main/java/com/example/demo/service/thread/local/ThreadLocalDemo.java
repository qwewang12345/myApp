package com.example.demo.service.thread.local;

import java.util.Random;

/**
 * @author gaonan1
 * @date 2021/1/8 21:57
 **/
public class ThreadLocalDemo extends Thread {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ThreadLocalDemo().start();
        }
    }

    @Override
    public void run() {
        // 线程
        Context context = new Context();
        Random random = new Random();
        int age = random.nextInt(100);
        context.set("age", String.valueOf(age));

        System.out.println("set thread [" + getName() + "] contextid to " + age);
        // 在ThreadLocal中设置context
        MyThreadLocal.set(context);
        /* note that we are not explicitly passing the transaction id */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String age1 = MyThreadLocal.get().get().get("age");
        System.out.println("thread" + getName() + "取出的年龄为" + age1);
        MyThreadLocal.unset();
    }
}
