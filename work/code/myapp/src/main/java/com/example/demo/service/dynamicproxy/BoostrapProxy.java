package com.example.demo.service.dynamicproxy;

import com.example.demo.service.aop.svc.DateSvc;
import com.example.demo.service.aop.svc.TestSvc;
import com.example.demo.service.aop.svc.TestTarget;
import com.example.demo.service.dynamicproxy.cglib.CGLibProxy;
import com.example.demo.service.dynamicproxy.cglib.CGLibProxy1;
import com.example.demo.service.dynamicproxy.cglib.CgLibProxyFactory;
import com.example.demo.service.dynamicproxy.jdkproxy.MyHanlder;
import com.example.demo.service.dynamicproxy.jdkproxy.StudentInterface;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @author gaonan1
 * @date 2020/5/14
 **/
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.example.demo.service.dynamicproxy")
public class BoostrapProxy {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\myapp\\com\\sum\\proxy");
        StudentBean student = new StudentBean("lilili");
        CGLibProxy proxy = new CGLibProxy();
        CGLibProxy1 proxy1 = new CGLibProxy1();
        StudentBean studentProxy1 = (StudentBean) CgLibProxyFactory.getInstance(proxy, proxy1, student);
        studentProxy1.setName("lili");
        studentProxy1.print();
        studentProxy1.print1();

        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        StudentBean student1 = new StudentBean("abc");
        student1.print();
        MyHanlder myHanlder = new MyHanlder(student1);
        StudentInterface studentProxy = (StudentInterface) Proxy.newProxyInstance(student1.getClass().getClassLoader(), student1.getClass().getInterfaces(), myHanlder);
        studentProxy.print();
        studentProxy.print1();
    }
}
