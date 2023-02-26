package com.example.demo.service.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author gaonan1
 * @date 2021/4/14 22:32
 **/
public class BeanTest {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/example/demo/service/ioc/xml/spring-config.xml");
        context.destroy();
    }
}
