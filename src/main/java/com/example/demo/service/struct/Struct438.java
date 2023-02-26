package com.example.demo.service.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaonan1
 * @date 2021/10/15 0:02
 **/
public class Struct438 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res =  findAnagrams(s, p);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) {
            return res;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        // 统计p中出现字符个数
        for (int i = 0; i < n; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        // s字符双指针滑动
        int left= 0;
        for (int right = 0; right < m; right++) {
            int rightIndex = s.charAt(right) - 'a';
            System.out.println(rightIndex);
            sCount[rightIndex]++;
            while (sCount[rightIndex] > pCount[rightIndex]) {
                int leftIndex = s.charAt(left) - 'a';
                sCount[leftIndex]--;
                left++;
            }
            // 每一个值都经过比较，所以是相等的
            if (right - left + 1 == n) {
                res.add(left);
            }
        }
        return res;
    }
}
