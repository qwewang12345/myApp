package com.example.demo.service.jvm.weak;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author gaonan
 * @date 2022/5/18 下午9:55
 */
public class GCTargetWeakReference extends WeakReference<GCTarget> {
    // 弱引用的ID
    public String id;

    public GCTargetWeakReference(GCTarget gcTarget,
                                 ReferenceQueue<? super GCTarget> queue) {
        super(gcTarget, queue);
        this.id = gcTarget.id;
    }

    @Override
    protected void finalize() {
        System.out.println("Finalizing GCTargetWeakReference " + id);
    }
}