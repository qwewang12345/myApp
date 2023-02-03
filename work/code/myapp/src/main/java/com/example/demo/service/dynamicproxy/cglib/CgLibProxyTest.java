package com.example.demo.service.dynamicproxy.cglib;

import com.example.demo.service.dynamicproxy.StudentBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gaonan1
 * @date 2019/11/19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CgLibProxyTest {

    @Test
    public void testProxy() {
        StudentBean student = new StudentBean("lilili");
        CGLibProxy proxy = new CGLibProxy();
        CGLibProxy1 proxy1 = new CGLibProxy1();
        StudentBean studentProxy = (StudentBean) CgLibProxyFactory.getInstance(proxy, proxy1, student);
        studentProxy.setName("lili");
        studentProxy.print();
        studentProxy.print1();
    }

}


