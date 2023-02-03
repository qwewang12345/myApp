package com.example.demo.service.collection;

import java.util.PriorityQueue;

/**
 * @author gaonan1
 * @date 2021/5/10 11:31
 **/
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.add(6);
        p.add(5);
        p.add(4);
        p.add(7);
        p.remove(6);
    }
}
