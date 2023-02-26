package com.example.demo.service.struct;

import org.apache.dubbo.common.utils.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaonan1
 * @date 2021/8/20 11:26
 **/
public class Struct96 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int getTreeCount(int n) {
        // i个元素能组成的二叉搜索树能有几种
        int[] dp = new int[n + 1];
        // 初始化，0个和1个时都是1种
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // j代表根节点的位置，取第几个元素
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}