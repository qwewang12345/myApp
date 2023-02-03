package com.example.demo.service.struct;

import java.util.HashSet;
import java.util.Set;

/**
 * 只求路径数有几个即可
 * @author gaonan1
 * @date 2021/5/11 10:27
 **/
public class EightQueenTwo {

    private static int count = 0;

    public static void main(String[] args) {
        int a = getEightQueenTwoCount(4);
        System.out.println(a);
    }

    public static int getEightQueenTwoCount(int n) {
        Set<Integer> leftSlash = new HashSet<>();
        Set<Integer> rightSlash = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        backTrack(0, n, leftSlash, rightSlash, column);
        return count;
    }

    private static void backTrack(int row, int n, Set<Integer> leftSlash, Set<Integer> rightSlash, Set<Integer> column) {
        // row等于n，说明所有行都有位置放元素
        if (row == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (column.contains(j)) {
                continue;
            }
            int left = row + j;
            if (leftSlash.contains(left)) {
                continue;
            }
            int right = row - j;
            if (rightSlash.contains(right)) {
                continue;
            }
            column.add(j);
            leftSlash.add(left);
            rightSlash.add(right);
            backTrack(row + 1, n, leftSlash, rightSlash, column);
            column.remove(j);
            leftSlash.remove(left);
            rightSlash.remove(right);
        }
    }
}
