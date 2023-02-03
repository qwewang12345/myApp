package com.example.demo.service.ioc.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author gaonan1
 * @date 2021/4/14 22:13
 **/
public class Person implements DisposableBean, InitializingBean, BeanFactoryAware, BeanNameAware {

    private String name;

    Person() {
        System.out.println("Constructor of person bean is invoked!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory method of person is invoked");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName method of person is invoked");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean Destroy method of person bean is invoked!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method of person bean is invoked!");
    }

    public void init() {
        System.out.println("custom init method of person bean is invoked!");
    }

    public void destroyMethod() {
        System.out.println("custom Destroy method of person bean is invoked!");
    }
}
