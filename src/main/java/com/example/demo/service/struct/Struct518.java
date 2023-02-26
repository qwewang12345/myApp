package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/7/8 9:52
 **/
public class Struct518 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int count = change1(amount, coins);
        System.out.println(count);
    }

    public static int change(int amount, int[] coins) {
        // dp数组代表amount为j时，有几种组合方式
        int[] dp = new int[amount + 1];
        // amount为0时，有1种
        dp[0] = 1;
        // 先遍历物品，再遍历容量,这样物品顺序固定，计算的是组合数，而不是排列数
        // 先遍历容量，再遍历物品，会是排列的感觉，因为每个容量下，都从头取物品，
        // 以3为例，会出现遍历1的时候，先拿2的组合数加上去，然后遍历2的时候，再拿1
        // 的组合数加上去，就是排列了。
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 状态转移，不取coins[i],加上取coins[i]的组合数
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static int change1(int amount, int[] coins) {
        // dp数组代表amount为j时，有几种组合方式
        int[] dp = new int[amount + 1];
        // amount为0时，有1种
        dp[0] = 1;
        // 先遍历容量，再遍历物品，会是排列的感觉，因为每个容量下，都从头取物品，
        // 以3为例，会出现遍历1的时候，先拿2的组合数加上去，然后遍历2的时候，再拿1
        // 的组合数加上去，就是排列了。
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    // 状态转移，不取coins[i],加上取coins[i]的组合数
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        return dp[amount];
    }
}
