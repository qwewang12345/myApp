package com.example.demo.service.jvm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author gaonan1
 * @date 2021/2/8 17:41
 **/
public class MyClassLoader extends ClassLoader {

    public MyClassLoader() {
        super(null);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            System.out.println("执行到自己写的findClass了");
            byte[] allBytes = Files.readAllBytes(Paths.get("/Users/gaonan/work/code/myapp/target/classes", name.replace(".", "/") + ".class"));
            System.out.println("执行完成");
            return defineClass(name, allBytes, 0, allBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        }
    }
}
