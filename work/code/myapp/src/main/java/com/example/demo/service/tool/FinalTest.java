package com.example.demo.service.tool;

import lombok.Builder;
import lombok.Data;

/**
 * @author gaonan1
 * @date 2021/1/7 22:12
 **/
public class FinalTest {

    public static void main(String[] args) {
        Student a = Student.builder().name("abc").build();
        final Student b = a;
        a = Student.builder().name("123").build();
    }
}
