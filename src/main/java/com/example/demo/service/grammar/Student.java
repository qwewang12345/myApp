package com.example.demo.service.grammar;

import lombok.Builder;

/**
 * @author gaonan1
 * @date 2019/11/18
 **/
public class Student extends Person {

    @Builder
    public Student(String name, Integer age) {
        super(name, age);
    }
}
