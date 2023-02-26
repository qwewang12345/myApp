package com.example.demo.service.jvm.phantom;

import com.example.demo.service.jvm.weak.GCTarget;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author gaonan
 * @date 2022/5/18 下午9:55
 */
public class GCTargetPhantomReference extends PhantomReference<GCTarget> {
    // 弱引用的ID
    public String id;

    public GCTargetPhantomReference(GCTarget gcTarget,
                                    ReferenceQueue<? super GCTarget> queue) {
        super(gcTarget, queue);
        this.id = gcTarget.id;
    }

    @Override
    protected void finalize() {
        System.out.println("Finalizing GCTargetWeakReference " + id);
    }
}