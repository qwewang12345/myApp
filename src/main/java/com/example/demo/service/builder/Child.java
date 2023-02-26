package com.example.demo.service.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * @author gaonan1
 * @date 2020/2/4
 **/
public class Child extends Parent {

    private String c;

    @Builder
    public Child(String b, String c) {
        super(b);
        this.c = c;
    }
}
