package com.example.demo.service.jvm;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Author: gaonan
 * @Date: 2020/2/27
 * @Description:
 */
public class WeakReferenceDemo {

    public static void main(String[] args) throws InterruptedException {

        ReferenceQueue<String> queue = new ReferenceQueue<>();

        String str = new String("abc");
        WeakReference<String> weakReference = new WeakReference<>(str);

        String str1 = new String("bcd");
        // 可以结合ReferenceQueue使用，回收时会放到queue中
        WeakReference<String> queueWeakReference = new WeakReference<>(str1, queue);

        str = null;
        str1 = null;

        System.gc();

        Thread.sleep(3000L);

        System.out.println(weakReference.get());
        System.out.println(queueWeakReference.get());
        System.out.println(queue.poll());
    }

}
