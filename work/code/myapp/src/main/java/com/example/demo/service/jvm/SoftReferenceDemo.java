package com.example.demo.service.jvm;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @Author: gaonan
 * @Date: 2020/2/27
 * @Description:
 */
public class SoftReferenceDemo {

    public static void main(String[] args) throws InterruptedException {

        ReferenceQueue<String> queue = new ReferenceQueue<>();

        String str = "abc";
        SoftReference<String> softReference = new SoftReference<>(str);

        String str1 = "bcd";
        // 可以结合ReferenceQueue使用，回收时会放到queue中
        SoftReference<String> queueSoftReference = new SoftReference<>(str1, queue);

        System.out.println(softReference.get());
        System.out.println(queueSoftReference.get());
    }

}
