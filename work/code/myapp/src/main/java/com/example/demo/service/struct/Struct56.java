package com.example.demo.service.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author gaonan1
 * @date 2021/5/18 10:20
 **/
public class Struct56 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 最后一个区间是否合并
        boolean flag = false;
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            // i从1开始，但实际上没有重合时，加入的是i - 1
            // 方便进行i-1的计算
            int left = intervals[i - 1][0];
            int right = intervals[i - 1][1];
            // 迭代直到新的区间，左侧和之前重合区间最大右侧没有重合
            while (i < len && intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
                // 内部迭代已经取了最后一个区间
                if (i == len - 1) {
                    flag = true;
                }
                i++;
            }
            res.add(new int[]{left, right});
        }
        // 最后一个区间没有
        if (!flag) {
            res.add(intervals[len - 1]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
