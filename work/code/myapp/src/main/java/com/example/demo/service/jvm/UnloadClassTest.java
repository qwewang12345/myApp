package com.example.demo.service.jvm;

/**
 * @author gaonan
 * @date 2022/6/16 下午10:46
 */
public class UnloadClassTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        System.out.println("开始加载Sample类");
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.findClass(Student.class.getName());
        Object obj = clazz.newInstance();
// 当代表类的Class对象不在被引用时，Class对象就会结束生命周期，类在方法区内的数据也会被卸载
        obj = null;
        clazz = null;
       // myClassLoader = null;
        System.gc();
        Thread.sleep(3000);
        System.out.println("执行结束....");
    }
}
