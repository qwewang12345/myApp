package com.example.demo.service.dynamicproxy.jdkproxy;

import com.example.demo.service.dynamicproxy.StudentBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

/**
 * @author gaonan1
 * @date 2019/11/19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdkProxyTest {

    @Test
    public void testProxy() {
        StudentBean student = new StudentBean("abc");
        student.print();
        MyHanlder myHanlder = new MyHanlder(student);
        StudentInterface studentProxy = (StudentInterface) Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(), myHanlder);
        studentProxy.print();
        studentProxy.print1();
    }

}


