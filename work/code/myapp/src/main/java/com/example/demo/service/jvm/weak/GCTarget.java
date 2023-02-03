package com.example.demo.service.jvm.weak;

/**
 * @author gaonan
 * @date 2022/5/18 下午9:54
 */
public class GCTarget {
    // 对象的ID
    public String id;

    // 占用内存空间
    byte[] buffer = new byte[1024];

    public GCTarget(String id) {
        this.id = id;
    }

//    @Override
//    protected void finalize() throws Throwable {
//        // 执行垃圾回收时打印显示对象ID
//        System.out.println("Finalizing GCTarget, id is : " + id);
//    }
}