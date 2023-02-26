package com.example.demo.service.struct;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * 这种解法更适合于n*n的矩阵
 * @author gaonan1
 * @date 2021/5/13 10:03
 **/
public class Struct54 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = visitMatrix(matrix);
        System.out.println(res);
    }

    private static List<Integer> visitMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int level = row / 2;
        for (int i = 0; i < level; i++) {
            int rowLimit = row - i - 1;
            int colLimit = col - i - 1;
            for (int upper = i; upper < colLimit; upper++) {
                res.add(matrix[i][upper]);
            }
            for (int right = i; right < rowLimit; right++) {
                res.add(matrix[right][rowLimit]);
            }
            for (int low = colLimit; low > i; low--) {
                res.add(matrix[rowLimit][low]);
            }
            for (int left = rowLimit; left > i; left--) {
                res.add(matrix[left][i]);
            }
        }
        if (row % 2 != 0) {
            res.add(matrix[level][level]);
        }
        return res;
    }
}
