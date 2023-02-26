package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private String a = "hihihi";

    @Test
    public void contextLoads() {

        System.out.print(a);
    }

    @Test
    public void test() {
        double m = Math.pow(1.02, 30);
        Map<String, String> a = new HashMap<>();
        a.put("c", "d");
        a.put("e", "f");
    }

    @Test
    public void testVar() {
        int a = 10;
        int b = a;
        b = 12;
        System.out.print(b);
    }

    @Test
    public void testDivision() {
        int a = 7;
        int b = -2;
        int c = a / b;
        int d = a % b;
    }

}
