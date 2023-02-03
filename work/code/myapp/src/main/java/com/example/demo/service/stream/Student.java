package com.example.demo.service.stream;

import lombok.Builder;
import lombok.Data;

/**
 * @author gaonan1
 * @date 2020/4/20
 **/
@Data
@Builder
public class Student {

    /**
     * 名称
     */
    private String name;

    /**
     * 年纪
     */
    private int age;
}
