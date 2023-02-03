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
public class Struct406 {

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = reconstructQueue(people);
        System.out.println(res);
    }

    public static int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排序，所以反着减，位置从小到大排序，所以正着减
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        int len = people.length;
        List<int[]> res = new ArrayList<>(len);
        // 按要插入的位置插入，因为之前插入的都大于等于当前值
        // 所以按index插入即可
        for (int[] p: people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[len][]);
    }

}
