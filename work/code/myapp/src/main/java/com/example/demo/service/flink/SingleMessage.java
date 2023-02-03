package com.example.demo.service.flink;

import lombok.Data;

/**
 * @author gaonan1
 * @date 2021/2/4 14:08
 **/
@Data
public class SingleMessage {

    private long timeLong;
    private String name;
    private String bizID;
    private String time;
    private String message;
}
