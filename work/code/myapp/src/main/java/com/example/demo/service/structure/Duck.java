package com.example.demo.service.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gaonan1
 * @date 2020/5/19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Duck {

    @JsonProperty("duck_name")
    private String duckName;

    @JsonProperty("age_num")
    private Integer ageNum;

    private Long userId;
}
