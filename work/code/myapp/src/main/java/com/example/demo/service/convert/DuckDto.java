package com.example.demo.service.convert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gaonan1
 * @date 2020/5/8
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DuckDto {

    private String name;

    private Integer age;
}
