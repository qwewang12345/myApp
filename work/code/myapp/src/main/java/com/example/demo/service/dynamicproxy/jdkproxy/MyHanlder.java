package com.example.demo.service.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyHanlder implements InvocationHandler {
    private Object target;

    public MyHanlder(Object target) {
        this.target = target;
    }

    /**
     * 处理业务逻辑：
     * 当Student存在名字则直接打印“Hello World”
     * 将如Student的名称为空，则输出相关的信息。如“名称为空，代理类已经拦截”等，
     * 表明代理类已经起作用了。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("执行原有方法前置处理");
        Object invoke = method.invoke(target, args);
        System.out.println("执行原有方法后置处理");
        return invoke;
    }
}