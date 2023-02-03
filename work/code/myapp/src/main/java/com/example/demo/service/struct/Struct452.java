package com.example.demo.service.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 按身高把学生排队
 * @author gaonan1
 * @date 2021/7/5 9:35
 **/
public class Struct452 {

    public static void main(String[] args) {
        int[][] airs = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int res = getResult(airs);
        System.out.println(res);
    }

    public static int getResult(int[][] points) {
        // 按气球起始边界从左往右排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int result = 0;
        int minRight = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // 左边界大于最小公共右边界，需要的箭加1
            if (points[i][0] > minRight) {
                result++;
                minRight = points[i][1];
            } else {
                // 重合继续求最小右边界
                minRight = Math.min(minRight, points[i][1]);
            }
        }
        return result;
    }

}
