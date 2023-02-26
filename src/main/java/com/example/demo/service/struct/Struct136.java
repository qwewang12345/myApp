package com.example.demo.service.struct;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gaonan1
 * @date 2021/8/25 9:39
 **/
public class Struct136 {

    public int getSingle(int[] nums) {
        // 使用额外空间，可以用map统计出现次数，或者set重复即删除,不写了
        // 不使用额外空间，直接用异或，数字和0异或，还是自己，相同的数字异或为0，
        // 满足交换律和结合律
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
