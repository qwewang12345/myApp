package com.example.demo.service.spring.ioc.single;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author gaonan1
 * @date 2020/10/16 10:27
 **/
@Configuration
@ComponentScan("com.example.demo.service.*")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Resource
    private DefaultTestService defaultTestService;
    @Resource
    private DefaultTestService1 defaultTestService1;

    @Test
    public void singletonTest() {
        defaultTestService.incCount();
        int i = defaultTestService1.getCount();
        defaultTestService1.incCount();
        int j = defaultTestService.getCount();
        TestDao testDao = defaultTestService.getTestDao();
        TestDao testDao1 = defaultTestService1.getTestDao();
    }
}
