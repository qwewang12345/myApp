package com.example.demo.service.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gaonan1
 * @date 2020/11/10 19:48
 **/
public class AtomicIntegerTest {

    private static AtomicInteger atoInteger = new AtomicInteger();

    public static void main(String[] args) {
        atoInteger.incrementAndGet();
        atoInteger.incrementAndGet();
    }
}
