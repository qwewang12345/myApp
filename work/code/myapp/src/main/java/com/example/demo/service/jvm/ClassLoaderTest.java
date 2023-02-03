package com.example.demo.service.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author gaonan1
 * @date 2021/2/2 22:55
 **/
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        // 自定义类加载器
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(fileName);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        // 使用ClassLoaderTest的类加载器加载本类
        Object obj1 = ClassLoaderTest.class.getClassLoader().loadClass("com.example.demo.service.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj1.getClass());
        System.out.println(obj1 instanceof com.example.demo.service.jvm.ClassLoaderTest);

        // 使用自定义类加载器加载本类
        Object obj3 = myLoader.loadClass("com.example.demo.service.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj3.getClass());
        System.out.println(obj3 instanceof com.example.demo.service.jvm.ClassLoaderTest);
    }
}
