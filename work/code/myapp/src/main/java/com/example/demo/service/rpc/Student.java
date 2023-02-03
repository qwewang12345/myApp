package com.example.demo.service.rpc;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author gaonan1
 * @date 2021/1/19 21:30
 **/
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String sex;
}
