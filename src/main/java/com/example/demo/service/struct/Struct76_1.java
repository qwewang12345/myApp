package com.example.demo.service.struct;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaonan1
 * @date 2021/8/16 9:31
 **/
public class Struct76_1 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        // 数组当hash用，操作更快，更节省空间
        int[] target = new int[128];
        int[] count = new int[128];

        for (char ch : t.toCharArray()) {
            target[ch]++;
        }
        String str = "";
        int l = 0;
        // 遍历顺序当右边界
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            // 不断移动左边界，只要count中对应的字符大于target中,就减一
            // 滑动窗口的精髓
            while (l <= i && count[s.charAt(l)] > target[s.charAt(l)]) {
                count[s.charAt(l)]--;
                l++;
            }
            // 校验count是否包含了target
            if (checkContain(target, count)) {
                if (str.length() == 0) {
                    str = s.substring(l, i + 1);
                } else {
                    if (i - l + 1 < str.length()) {
                        str = s.substring(l, i + 1);
                    }
                }
            }
        }
        return str;
    }

    private static boolean checkContain(int[] target, int[] count) {
        for (int i = 0; i < target.length; i++) {
            if (target[i] > count[i]) {
                return false;
            }
        }
        return true;
    }
}
