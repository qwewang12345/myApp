package com.example.demo.service.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gaonan1
 * @date 2021/6/17 9:57
 **/
@Configuration
@ComponentScan("com.example.demo.service.spi.*")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboSpiTest {

    @Test
    public void sayHello() throws Exception {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
        Robot adaptive = extensionLoader.getAdaptiveExtension();
        adaptive.sayHello();
    }
}
