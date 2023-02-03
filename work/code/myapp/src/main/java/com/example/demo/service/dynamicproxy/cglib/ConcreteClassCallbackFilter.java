package com.example.demo.service.dynamicproxy.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author gaonan1
 * @date 2021/5/25 11:05
 **/
public class ConcreteClassCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if ("print".equals(method.getName())) {
            return 0;
        } else {
            return 1;
        }
    }
}
