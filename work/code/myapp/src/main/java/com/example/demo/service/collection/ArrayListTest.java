package com.example.demo.service.collection;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaonan1
 * @date 2020/11/5 18:52
 **/
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>(2);
        l.add("a");
        l.add("b");
        l.add("c");
        System.out.println(StringUtils.join(l, ","));
    }
}
