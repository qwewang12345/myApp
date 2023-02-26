package com.example.demo.service.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaonan1
 * @date 2021/7/14 9:46
 **/
public class Struct39 {

    public static List<List<Integer>> res = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return res;
    }

    public static void dfs(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }
        // 每层遍历，虽然每个可以重复取，但不能反着取，不然组合就重复了，如（2,3）（3,2）
        for (int i = startIndex; i < candidates.length; i++) {
            // 剪枝，大于target，后续也会大于
            if (sum + candidates[i] > target) {
                break;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            // 可以重复取，i不加1
            dfs(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
