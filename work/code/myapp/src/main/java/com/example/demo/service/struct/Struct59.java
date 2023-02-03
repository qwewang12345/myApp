package com.example.demo.service.struct;

import java.util.PriorityQueue;

/**
 * @author gaonan1
 * @date 2021/10/10 12:02
 **/
public class Struct59 {

    public static void main(String[] args) {
        int n = 4;
        int[][] res = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] generateMatrix(int n) {
        // 旋转圈数
        int loop = n / 2;
        // 旋转圈起始位置
        int l = 0;
        // 自增开始的数值
        int num = 1;
        int[][] res = new int[n][n];
        while (l < loop) {
            int i = l;
            int j = l;
            // 上边，都是左闭右开
            for (; j < n - 1 - l; j++) {
                res[i][j] = num++;
            }
            // 右边
            for (; i < n - 1 - l; i++) {
                res[i][j] = num++;
            }
            // 下边
            for (; j > l; j--) {
                res[i][j] = num++;
            }
            // 左边
            for (; i > l; i--) {
                res[i][j] = num++;
            }
            l++;
        }
        // 奇数时中间单独填充
        if (n % 2 == 1) {
            res[loop][loop] = num;
        }
        return res;
    }
}
