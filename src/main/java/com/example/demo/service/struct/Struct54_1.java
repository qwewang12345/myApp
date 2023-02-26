package com.example.demo.service.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * 这种解法适合不规则的矩阵
 * @author gaonan1
 * @date 2021/5/13 10:03
 **/
public class Struct54_1 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = visitMatrix(matrix);
        System.out.println(res);
    }

    private static List<Integer> visitMatrix(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (left <= right && top <= down) {
            // 左闭右闭，在左右相同时也能取值
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            // 左开右闭，在上下相同时也能取值
            for (int row = top + 1; row <= down; row++) {
                res.add(matrix[row][right]);
            }
            if (left < right && top < down) {
                for (int col = right - 1; col > left; col--) {
                    res.add(matrix[down][col]);
                }
                for (int row = down; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            down--;
        }
        return res;
    }
}
