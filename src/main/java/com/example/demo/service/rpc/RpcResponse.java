package com.example.demo.service.rpc;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gaonan1
 * @date 2021/1/19 21:41
 **/
@Data
public class RpcResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    // 可能抛出的异常
    private Throwable error;
    // 响应的内容或结果
    private Object result;
}
