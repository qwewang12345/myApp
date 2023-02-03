package com.example.demo.service.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author gaonan1
 * @date 2020/5/14
 **/
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
public class Config {

}
