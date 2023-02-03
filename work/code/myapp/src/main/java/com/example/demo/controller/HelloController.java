package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaonan1
 * @date 2019/9/23 12:53
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String getHello() {
        return "hello";
    }
}
