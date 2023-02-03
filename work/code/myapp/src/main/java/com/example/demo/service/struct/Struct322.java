package com.example.demo.service.struct;

import java.util.Arrays;

/**
 * @author gaonan1
 * @date 2021/9/6 10:20
 **/
public class Struct322 {

    public int getLeast(int[] coins, int amount) {
        // amount为j时，需要的最少金币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 初始化，amount为0时，
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount; j++) {
                // 比较之前i - 1个时，不取当前元素，和取当前元素的最小值
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount];
    }
}

