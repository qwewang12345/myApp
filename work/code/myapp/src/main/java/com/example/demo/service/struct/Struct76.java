package com.example.demo.service.struct;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaonan1
 * @date 2021/8/16 9:31
 **/
public class Struct76 {

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>(t.length());
        Map<Character, Integer> countMap = new HashMap<>(t.length());
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        int ansL = -1;
        int ansR = -1;
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int r = -1;
        while (r < s.length()) {
            r++;
            if (r < s.length() && targetMap.containsKey(s.charAt(r))) {
                countMap.put(s.charAt(r), countMap.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (checkContain(targetMap, countMap) && l <= r) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    ansL = l;
                    ansR = r;
                }
                if (targetMap.containsKey(s.charAt(l))) {
                    countMap.put(s.charAt(l), countMap.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    private static boolean checkContain(Map<Character, Integer> targetMap, Map<Character, Integer> countMap) {
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            char key = entry.getKey();
            if (countMap.getOrDefault(key, 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
