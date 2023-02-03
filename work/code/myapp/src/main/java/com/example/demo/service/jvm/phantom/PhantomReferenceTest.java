package com.example.demo.service.jvm.phantom;

import com.example.demo.service.jvm.weak.GCTarget;
import com.example.demo.service.jvm.weak.GCTargetWeakReference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;

/**
 * @author gaonan
 * @date 2022/5/18 下午9:56
 */
public class PhantomReferenceTest {
    // 弱引用队列
    private final static ReferenceQueue<GCTarget> REFERENCE_QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        LinkedList<GCTargetPhantomReference> gcTargetList = new LinkedList<>();

        // 创建弱引用的对象，依次加入链表中
        for (int i = 0; i < 5; i++) {
            GCTarget gcTarget = new GCTarget(String.valueOf(i));
            GCTargetPhantomReference phantomReference = new GCTargetPhantomReference(gcTarget,
                    REFERENCE_QUEUE);
            gcTargetList.add(phantomReference);

            System.out.println("Just created GCTargetWeakReference obj: " +
                    gcTargetList.getLast());
        }

        // 通知GC进行垃圾回收
        System.gc();

        try {
            // 休息几分钟，等待上面的垃圾回收线程运行完成
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 检查关联的引用队列是否为空
        Reference<? extends GCTarget> reference;
        while((reference = REFERENCE_QUEUE.poll()) != null) {
            if(reference instanceof GCTargetPhantomReference) {
                System.out.println("In queue, id is: " +
                        ((GCTargetPhantomReference) (reference)).id);
            }
            reference.clear();
        }

        // 通知GC进行垃圾回收
        System.gc();

        try {
            // 休息几分钟，等待上面的垃圾回收线程运行完成
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while((reference = REFERENCE_QUEUE.poll()) != null) {
            if(reference instanceof GCTargetPhantomReference) {
                System.out.println("In queue, id is: " +
                        ((GCTargetPhantomReference) (reference)).id);
                reference.clear();
            }
        }

        // 通知GC进行垃圾回收
        System.gc();

        try {
            // 休息几分钟，等待上面的垃圾回收线程运行完成
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(gcTargetList);
    }
}
