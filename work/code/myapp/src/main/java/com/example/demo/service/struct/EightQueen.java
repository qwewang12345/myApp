package com.example.demo.service.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaonan1
 * @date 2021/4/30 15:30
 **/
public class EightQueen {

    public static void main(String[] args) {
        getEightQueenList(4);
    }

    public static List<List<String>> getEightQueenList(int n) {
        // 每行queen放置的位置
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 当前列，左、右斜线出现过queen的集合
        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        backTrack(0, n, queens, columnSet, leftSet, rightSet, res);
        return res;
    }

    private static void backTrack(int row, int n, int[] queens, Set<Integer> columnSet, Set<Integer> leftSet, Set<Integer> rightSet, List<List<String>> res) {
        if (row == n) {
            res.add(genString(queens));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (columnSet.contains(j)) {
                continue;
            }
            int left = row + j;
            if (leftSet.contains(left)) {
                continue;
            }
            int right = row - j;
            if (rightSet.contains(right)) {
                continue;
            }
            queens[row] = j;
            columnSet.add(j);
            leftSet.add(left);
            rightSet.add(right);
            backTrack(row + 1, n, queens, columnSet, leftSet, rightSet, res);
            queens[row] = -1;
            columnSet.remove(j);
            leftSet.remove(left);
            rightSet.remove(right);
        }
    }

    private static List<String> genString(int[] queens) {
        int n = queens.length;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] a = new char[n];
            Arrays.fill(a, '.');
            a[queens[i]] = 'Q';
            result.add(new String(a));
        }
        return result;
    }

//    public static List<List<String>> getEightQueenList(int n) {
//        // 判断是否还能放置queen的二维数组
//        boolean[][] invalid = new boolean[n][n];
//        // 返回结果
//        char[][] res = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                res[i][j] = '.';
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            boolean flag = false;
//            for (int j = 0; j < n; j++) {
//                if (invalid[i][j]) {
//                    continue;
//                }
//                flag = true;
//                res[i][j] = 'Q';
//                addInvalid(invalid, i, j, n);
//                break;
//            }
//            // 说明当前行已经找不到合适的位置了，回退到上一行，试试其它列
//            if (!flag) {
//
//            }
//        }
//        return null;
//    }
//
//
//
//
//    private static void addInvalid(boolean[][] invalid, int i, int j, int n) {
//        int next = i;
//        while (next < n - 1) {
//            invalid[++next][j] = true;
//        }
//
//        int leftRow = i;
//        int leftCol = j;
//        while (leftRow < n - 1 && leftCol > 0) {
//            invalid[++leftRow][--leftCol] = true;
//        }
//
//        int rightRow = i;
//        int rightCol = j;
//        while (rightRow < n - 1 && rightCol < n - 1) {
//            invalid[++rightRow][++rightCol] = true;
//        }
//    }
}
