package com.example.demo.service.convert;

import org.springframework.beans.BeanUtils;

/**
 * @author gaonan1
 * @date 2020/5/8
 **/
public class ConvertTest {

    public static void main(String[] args) {
        DuckPo duckPo = DuckPo.builder()
                .name("a")
                .age(11)
                .build();
        DuckDto duckDto = new DuckDto();
        BeanUtils.copyProperties(duckPo, duckDto);
    }
}
