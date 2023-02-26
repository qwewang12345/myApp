package com.example.demo.service.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gaonan1
 * @date 2020/11/5 20:32
 **/
public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Map<String, String> lruMap = new LruLinkedHashMap<>(2);
        lruMap.put("a", "1");
        lruMap.put("b", "2");
        lruMap.put("c", "3");
        System.out.println(lruMap);
    }
}
