package com.example.demo.service.struct;

import java.util.Stack;

/**
 * @author gaonan1
 * @date 2021/8/20 9:34
 **/
public class Struct85 {

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int j = 0; j < col; j++) {
            int[] up = new int[row];
            for (int i = 0; i < row; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            int[] down = new int[row];
            for (int i = row - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? row : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < row; i++) {
                int height = down[i] - up[i] - 1;
                maxArea = Math.max(maxArea, height * left[i][j]);
            }
        }
        return maxArea;
    }
}
