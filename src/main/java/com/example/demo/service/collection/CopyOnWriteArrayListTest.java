package com.example.demo.service.collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author gaonan1
 * @date 2020/11/29 17:14
 **/
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("123");
    }
}
