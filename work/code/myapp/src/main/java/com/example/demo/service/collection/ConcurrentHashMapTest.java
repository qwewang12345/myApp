package com.example.demo.service.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gaonan1
 * @date 2020/11/5 14:48
 **/
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Map<String, Long> map = new ConcurrentHashMap<>(2);
        map.put("abcde", 1L);
        map.put("bcc", 2L);
        map.put("cdddd", 3L);

        Map<String, Test> testMap = new HashMap<>();
        Test test = new Test();
        test.setTest("123");
        testMap.put("abc", test);
        for (Map.Entry<String, Test> entry : testMap.entrySet()) {
            entry.getValue().setTest("345");
        }

        Long a = map.get("bcc");

        HashMap<String, Long> map1;
    }
}
