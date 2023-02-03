package com.example.demo.service.thread.local;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文对象
 * @author gaonan1
 * @date 2021/1/8 21:44
 **/
public class Context {

    private Map<String, String> values = new HashMap<>();

    public Map<String, String> get() {
        return this.values;
    }

    public void set(String key, String value) {
        this.values.put(key, value);
    }
}
