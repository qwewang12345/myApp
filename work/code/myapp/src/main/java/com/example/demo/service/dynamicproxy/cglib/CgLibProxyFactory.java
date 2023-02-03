package com.example.demo.service.dynamicproxy.cglib;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * cglib代理工厂类
 * 注意实现的接口类是cglib包下的MethodInterceptor
 */
public class CgLibProxyFactory {

    /**
     * 创建代理类对象
     * @param cgLibProxy
     * @return 代理类对象
     */
    public static Object getInstance(CGLibProxy cgLibProxy, CGLibProxy1 cgLibProxy1, Object obj) {
        //利用Enhancer来创建代理类
        Enhancer enhancer = new Enhancer();
        //为目标对象指定父类
        enhancer.setSuperclass(obj.getClass());
        // 设置回调函数选择
        ConcreteClassCallbackFilter concreteClassCallbackFilter = new ConcreteClassCallbackFilter();
        enhancer.setCallbackFilter(concreteClassCallbackFilter);
        // 设置回调函数
        Callback[] callbacks = {cgLibProxy, cgLibProxy1};
        enhancer.setCallbacks(callbacks);
        // enhancer.setCallback(cgLibProxy);
        //返回生成的代理类
        return enhancer.create();
    }
}