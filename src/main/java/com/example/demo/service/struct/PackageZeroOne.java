package com.example.demo.service.struct;

/**
 * 0 1背包
 *
 * @author gaonan1
 * @date 2021/6/3 9:53
 **/
public class PackageZeroOne {

    public static void main(String[] args) {
        int[] weight = {1, 2, 3};
        int[] value = {15, 20, 25};
        int capacity = 4;
        getMaxValue2(weight, value, capacity);
    }

    private static int getMaxValue(int[] weight, int[] value, int capacity) {
        int m = weight.length;
        // 从前i个物品中，在容量为j时，计算出最大值
        int[][] dp = new int[m][capacity + 1];
        // 初始化，j为0时，列为0，i为0时，代表物品0,在不同容量下能装的最大值
        for (int j = capacity; j >= 0; j--) {
            if (j >= weight[0]) {
                dp[0][j] = dp[0][j - weight[0]] + value[0];
            }
        }
        // 遍历，从左到右，逐行遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][capacity];
    }

    private static int getMaxValue1(int[] weight, int[] value, int capacity) {
        int m = weight.length;
        // 从前i个物品中，在容量为j时，计算出最大值
        int[][] dp = new int[m][capacity + 1];
        // 初始化，j为0时，列为0，i为0时，代表物品0,在不同容量下能装的最大值
        for (int j = capacity; j >= 0; j--) {
            if (j >= weight[0]) {
                dp[0][j] = dp[0][j - weight[0]] + value[0];
            }
        }
        // 遍历，从上到下，逐列遍历，先遍历容量，再遍历物品
        for (int j = 1; j <= capacity; j++) {
            for (int i = 1; i < m; i++) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][capacity];
    }

    private static int getMaxValue2(int[] weight, int[] value, int capacity) {
        int m = weight.length;
        // dp[i]代表容量为i的容器，最大能装物品总和的价值
        int[] dp = new int[capacity + 1];
        // 整体思路，对比于二维数组，其实就是用一维数组，每次将上一行的前面的计算结果
        // 也放到当前行，起到节省空间的效果
        // 遍历
        for (int i = 0; i < m; i++) {
            for (int j = capacity; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[capacity];
    }

}
