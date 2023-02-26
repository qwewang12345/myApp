package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/9/6 10:20
 **/
public class Struct300 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // 以i为结尾的字符串，最大升序列的值
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        // 代表递增序列长度为i时，最小的末尾字符串
        int[] d = new int[len + 1];
        int n = 1;
        d[1] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > d[n]) {
                d[++n] = nums[i];
            } else {
                // 寻找nums[i]在d数组中，大于d[pos],小于d[pos+1]的位置，去更新pos+1的位置为更小的值
                // 下面的计算中，二分逼近，小于nums[i]的最大数，即pos位置
                int l = 1;
                int r = n;
                int pos = 0;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return n;
    }
}

