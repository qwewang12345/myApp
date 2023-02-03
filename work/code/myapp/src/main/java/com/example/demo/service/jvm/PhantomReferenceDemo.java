package com.example.demo.service.jvm;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Author: gaonan
 * @Date: 2020/2/27
 * @Description:
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) throws InterruptedException {

        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        // 虚引用必须要和引用队列一起使用，他的get方法永远返回null
        PhantomReference<byte[]> phantomReference = new PhantomReference<>(
                new byte[1024 * 1024 * 5], queue);

        System.out.println(phantomReference);
        System.out.println(queue.poll());

        System.gc();

        Thread.sleep(1000L);

        System.out.println(queue.poll());
        phantomReference = null;
        System.gc();

        Thread.sleep(1000L);

        System.out.println(phantomReference);
    }

}
