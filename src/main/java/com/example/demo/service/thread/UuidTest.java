package com.example.demo.service.thread;

import java.util.Random;
import java.util.UUID;

/**
 * @author gaonan1
 * @date 2020/12/28 11:30
 **/
public class UuidTest {

    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(generateSequenceID());
                }
            }).start();
        }
    }

    public static String generateSequenceID(){
        String uuid = UUID.randomUUID().toString();
        // String ranEight = String.format("%08d", new Random().nextInt(99999999));
        String ranEight = "";
        return uuid +"--"+ ranEight;
    }

}
