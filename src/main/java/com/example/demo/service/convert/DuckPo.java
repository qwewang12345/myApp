package com.example.demo.service.convert;

import lombok.Builder;
import lombok.Data;

/**
 * @author gaonan1
 * @date 2020/5/8
 **/
@Data
@Builder
public class DuckPo {

    private String name;

    private Integer age;
}
