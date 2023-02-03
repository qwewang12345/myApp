package com.example.demo.service.jvm;

/**
 * @author gaonan1
 * @date 2021/2/9 15:10
 **/
public class MyLoadClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyLoadClassLoader myLoadClassLoader = new MyLoadClassLoader();
        Object object = myLoadClassLoader.loadClass("com.example.demo.service.jvm.Student", true).newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof com.example.demo.service.jvm.Student);
        System.out.println(Thread.currentThread().getContextClassLoader());

        Object obj1 = ClassLoaderTest.class.getClassLoader().loadClass("com.example.demo.service.jvm.Student").newInstance();
        System.out.println(obj1.getClass());
        System.out.println(obj1 instanceof com.example.demo.service.jvm.Student);
    }
}
