package com.example.demo.service.json;

import lombok.Builder;
import lombok.Data;

/**
 * @author gaonan1
 * @date 2021/6/29 10:16
 **/
@Data
public class Student extends Person {

    private Long score;

    private String classes;
}
