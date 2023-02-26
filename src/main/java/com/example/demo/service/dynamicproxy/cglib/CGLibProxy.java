package com.example.demo.service.dynamicproxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author gaonan1
 * @date 2019/11/19
 **/
public class CGLibProxy implements MethodInterceptor {

    // 实现回调处理方法，类似InvocationHandler中的invoke方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("~~~ Before Log ~~~");
        System.out.println("calling method: " + proxy.getSignature().getName());
        /*
         * proxy是代理方法，所以这里必须要通过proxy.invokeSuper(obj, args)来调用原来Student类
         * 中的方法，如果这里是proxy.invoke(obj, args),则调用的还是proxy方法本身，从而导致无限
         * 递归，注意一定不要调用错误了
         */
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("~~~ After Log ~~~");

        return result;
    }
}
