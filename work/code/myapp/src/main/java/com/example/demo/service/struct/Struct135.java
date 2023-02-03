package com.example.demo.service.struct;

import java.util.Arrays;

/**
 * @author gaonan1
 * @date 2021/6/27 19:35
 **/
public class Struct135 {

    public static void main(String[] args) {
        int[] ratings = {1, 3, 4, 5, 2};
        int s = candy(ratings);
        System.out.println(s);
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        // 从左到右,右边大于左边则加1，局部最优推出单线全局最优
        for (int j = 0; j < n - 1; j++) {
            if (ratings[j + 1] > ratings[j]) {
                nums[j + 1] = nums[j] + 1;
            }
        }
        // 从右往左，左边大于右边则加1，局部最优推出单线全局最优
        for (int k = n - 1; k > 0; k--) {
            if (ratings[k - 1] > ratings[k]) {
                nums[k - 1] = Math.max(nums[k] + 1, nums[k - 1]);
            }
        }

        int sum = 0;
        for (int m = 0; m < n; m++) {
            sum += nums[m];
        }
        return sum;
    }
}
