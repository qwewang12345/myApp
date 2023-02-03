package com.example.demo.service.collection;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author gaonan1
 * @date 2020/11/5 14:48
 **/
public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>(8);
        map1.put("a", "1");
        map1.put("b", "2");
        map1.put("c", "3");

        Map<String, String> map2 = new HashMap<>(8);
        map2.put("b", "2");
        map2.put("a", "1");
        map2.put("c", "3");

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey());
        }

        for (Map.Entry<String, String> entry1 : map2.entrySet()) {
            System.out.println(entry1.getKey());
        }

    }
}
