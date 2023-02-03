package com.example.demo.service.struct;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaonan1
 * @date 2021/8/25 9:39
 **/
public class Struct139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        // 到第i(下标加1)个元素，是否能被wordDict填充
        boolean[] dp = new boolean[len + 1];
        // 初始化，0个元素能被填充,这样后面才有意义
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= i; j++) {
                // 到j位置都能被填充，判断j到i-1的字符串是否被包含
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
