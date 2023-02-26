package com.example.demo.service.collection.consitanthash;

import java.util.Random;

/**
 * @author gaonan1
 * @date 2020/11/6 20:22
 **/
public class IPAddressGenerate {

    public String[] getIPAddress(int num) {
        String[] res = new String[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            res[i] = String.valueOf(random.nextInt(256)) + "." + String.valueOf(random.nextInt(256)) + "."
                    + String.valueOf(random.nextInt(256)) + "." + String.valueOf(random.nextInt(256)) + ":"
                    + String.valueOf(random.nextInt(9999));
        }
        return res;
    }
}
