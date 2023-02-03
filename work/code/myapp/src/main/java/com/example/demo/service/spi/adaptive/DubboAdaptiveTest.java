package com.example.demo.service.spi.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * @author gaonan1
 * @date 2021/6/27 14:56
 **/
public class DubboAdaptiveTest {

    @Test
    public void test() {
        // 首先创建一个模拟用的URL对象
        URL url = URL.valueOf("dubbo://192.168.0.101:20880?fruitName=banana");
        // 通过ExtensionLoader获取一个FruitGranter对象
        ExtensionLoader<FruitGranter> extensionLoader = ExtensionLoader.getExtensionLoader(FruitGranter.class);
        FruitGranter fruitGranter = extensionLoader.getExtension("apple");
        fruitGranter.watering(url);
        FruitGranter granter = extensionLoader.getAdaptiveExtension();
        // 使用该FruitGranter调用其"自适应标注的"方法，获取调用结果
        String result = granter.watering(url);
        System.out.println(result);
    }
}
