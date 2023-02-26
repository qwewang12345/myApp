package com.example.demo.service.struct;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gaonan1
 * @date 2021/8/25 9:39
 **/
public class Struct128 {

    public int getMaxLen(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curLen = 1;
                while (set.contains(++num)) {
                    curLen += 1;
                }
                maxLen = Math.max(curLen, maxLen);
            }
        }
        return maxLen;
    }
}
