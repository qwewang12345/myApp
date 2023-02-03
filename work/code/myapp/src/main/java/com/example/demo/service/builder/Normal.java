package com.example.demo.service.builder;

import lombok.Builder;
import lombok.Data;

/**
 * @author gaonan1
 * @date 2020/2/4
 **/
@Builder(toBuilder = true)
@Data
public class Normal {

    private String m;

    private String n;
}
