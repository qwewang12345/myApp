package com.example.demo.service.tool;

/**
 * @author gaonan1
 * @date 2021/1/6 17:25
 **/
public class SplitTest {

    public static void main(String[] args) {
        String path = "/";
        int length = path.split("/").length;
        System.out.println(length);
    }
}
