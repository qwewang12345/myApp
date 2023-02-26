package com.example.demo.service.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gaonan1
 * @date 2020/11/5 22:24
 **/
public class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int maxSize;

    public LruLinkedHashMap(int maxSize) {
        super((int) (maxSize / 0.75), 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxSize;
    }
}
