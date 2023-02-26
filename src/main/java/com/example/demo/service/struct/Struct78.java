package com.example.demo.service.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * 求子集数
 * @author gaonan1
 * @date 2021/7/12 9:39
 **/
public class Struct78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(nums, 0, path, res);
        return res;
    }

    public static void backTrack(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> res) {
        // 每一步都符合要求，下面的条件startIndex到了len，就不会再走了，
        // 所以这里也不用做递归结束的判断了
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
