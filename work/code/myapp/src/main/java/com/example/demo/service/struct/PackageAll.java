package com.example.demo.service.struct;

/**
 * 完全背包
 *
 * @author gaonan1
 * @date 2021/6/3 9:53
 **/
public class PackageAll {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {5, 20, 25};
        int capacity = 4;
        getMaxValue(weight, value, capacity);
    }

    private static int getMaxValue(int[] weight, int[] value, int capacity) {
        int m = weight.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < m; i++) {
            for (int j = weight[i]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[capacity];
    }

}
