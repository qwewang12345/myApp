package com.example.demo.service.struct;

/**
 * 跳跃问题
 * @author gaonan1
 * @date 2021/5/14 9:53
 **/
public class Struct55 {

    class ListNode {
        int value;
        ListNode next;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean res = skip(nums);
    }

    private static boolean skip(int[] nums) {
        int n = nums.length;
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            if (i <= maxDistance) {
                maxDistance = Math.max(nums[i] + i, maxDistance);
                if (maxDistance >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
