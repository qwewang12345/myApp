package com.example.demo.service.spi;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author gaonan1
 * @date 2021/6/23 10:18
 **/
@Data
@Service
public class Student {

    private String name;

    private String age;

    public void print() {
        System.out.println("12345");
    }
}
