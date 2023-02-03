package com.example.demo.service.rpc;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gaonan1
 * @date 2021/1/19 21:35
 **/
@Data
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    // 需要请求的类名
    private String className;

    // 需求请求的方法名
    private String methodName;

    // 请求方法的参数类型
    private Class<?>[] paramTypes;

    // 请求的参数值
    private Object[] params;
}
