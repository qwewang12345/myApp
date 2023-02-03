package com.example.demo.service.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaonan
 * @date 2022/6/20 下午2:07
 */
public class ListDemo {

    public static void main(String[] args) {
        List<String> sList = new ArrayList<String>();
        List<String> sList2 = new ArrayList<String>();
        sList.add("1");
        sList.add("2");
        sList.add("3");
        sList.add("4");

        sList2.add("1");
        sList2.add("3");
        sList2.add("5");

        List<String> sList3 = new ArrayList<>(sList);
        sList3.retainAll(sList2);

        for(String s : sList) {
            System.out.println(s);
        }
    }
}
