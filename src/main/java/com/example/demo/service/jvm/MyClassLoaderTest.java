package com.example.demo.service.jvm;

/**
 * @author gaonan1
 * @date 2021/2/8 18:36
 **/
public class MyClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Object object = myClassLoader.loadClass("com.example.demo.service.jvm.Student").newInstance();
        Object object2 = ClassLoaderTest.class.getClassLoader().loadClass("com.example.demo.service.jvm.Student").newInstance();

        System.out.println(object instanceof Student);
        System.out.println(object2 instanceof Student);

// class xyz.kail.blog.CodeClass
        System.out.println(Class.forName("com.example.demo.service.jvm.Student", true, myClassLoader));

//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Thread.currentThread().getContextClassLoader());

        Thread.currentThread().setContextClassLoader(myClassLoader);
//classloader.MyClassLoader@24d46ca6
        System.out.println(Thread.currentThread().getContextClassLoader());

//class xyz.kail.blog.CodeClass
        System.out.println(Thread.currentThread().getContextClassLoader().loadClass("com.example.demo.service.jvm.Student"));

// xyz.kail.blog.CodeClass@372f7a8d
        System.out.println(myClassLoader.loadClass("com.example.demo.service.jvm.Student").newInstance());

//classloader.MyClassLoader@24d46ca6
        new Thread(() -> System.out.println(Thread.currentThread().getContextClassLoader())).start();
    }
}
