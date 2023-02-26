package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/5/12 11:12
 **/
public class struct53 {

    public static void main(String[] args) {
        int[] m = {1, 2, -1, 3, -1};
        int j = getMaxSum(m);
        System.out.println(j);
    }

    private static int getMaxSum(int[] m) {
        int maxSum = Integer.MIN_VALUE;
        int pre = 0;
        for (int i : m) {
            // 以当前位置结束的，连续和的最大值
            pre = Math.max(pre + i, i);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
}
