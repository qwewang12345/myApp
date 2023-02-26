package com.example.demo.service.jvm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gaonan1
 * @date 2021/2/9 14:49
 **/
public class MyLoadClassLoader extends ClassLoader {

    private final Map<String, Class<?>> cacheClass = new ConcurrentHashMap<>();

    public MyLoadClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
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

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // 检测缓存中有没有，有的话直接返回
            Class c = cacheClass.get(name);
            if (null != c) {
                return c;
            }
            // 缓存中没有
            try {
                c = findClass(name); // 先从自定义类路径下找
                if (null != c) {
                    cacheClass.put(name, c);
                }
            } catch (ClassNotFoundException ex) {
                c = super.loadClass(name, resolve); // 自定义类路径下没有再调用系统默认的加载机制
            }

            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
}
