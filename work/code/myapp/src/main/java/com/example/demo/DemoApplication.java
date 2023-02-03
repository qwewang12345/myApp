package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class DemoApplication {

    private String a = "hihihi";

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
    }



    public static void testRandom() {
        Random random = new Random(11);
        Random random1 = new Random(11);
        System.out.println(random.nextInt(10));
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));
    }
}
