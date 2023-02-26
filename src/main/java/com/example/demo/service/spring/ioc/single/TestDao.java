package com.example.demo.service.spring.ioc.single;

import org.springframework.stereotype.Component;

/**
 * @author gaonan1
 * @date 2020/10/16 10:25
 **/
@Component
public class TestDao {

    private Integer count =0;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
