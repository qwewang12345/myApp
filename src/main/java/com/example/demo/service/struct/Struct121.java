package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/25 9:39
 **/
public class Struct121 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 第i天0代表持有股票最多金额
        // 1代表不持有股票最多金额
        int[][] dp = new int[len][2];
        dp[0][0] = - prices[0];
        for (int i = 1; i < len; i++) {
            // 只买卖一次，所以每次都是和-prices[i]对比，之前不会有利润
            dp[i][0] = Math.max(dp[i - 1][0], - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][1];
    }
}
