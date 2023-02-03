package com.example.demo.service.rpc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gaonan1
 * @date 2021/1/19 22:10
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    /**
     * 注解所属接口类型
     * @return
     */
    Class<?> value();
}
