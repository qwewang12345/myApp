package com.example.demo.service.struct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaonan1
 * @date 2021/9/6 10:20
 **/
public class Struct301 {

    private char[] charArray;
    private Set<String> res = new HashSet<>();

    public List<String> remove(String s) {
        charArray = s.toCharArray();
        // 左右括号最少移除数
        int leftMove = 0;
        int rightMove = 0;
        for (char c : charArray) {
            if (c == ')') {
                if (leftMove > 0) {
                    leftMove--;
                } else {
                    rightMove++;
                }
            } else if (c == '(') {
                leftMove++;
            }
        }
        dfs(0, 0, 0, leftMove, rightMove, new StringBuilder());
        return new ArrayList<>(res);
    }

    private void dfs(int index, int leftCount, int rightCount, int leftMove, int rightMove, StringBuilder path) {
        // index到达末尾，且左右括号最小移除数是0
        if (index == charArray.length) {
            if (leftMove == 0 && rightMove == 0) {
                res.add(path.toString());
            }
        }
        char c = charArray[index];
        // 尝试删除
        if (c == '(' && leftMove > 0) {
            dfs(index + 1, leftCount, rightCount, leftMove - 1, rightMove, path);
        }
        if (c == ')' && rightMove > 0) {
            dfs(index + 1, leftCount, rightCount, leftMove, rightMove - 1, path);
        }
        // 尝试保留
        path.append(c);
        if (c != '(' && c != ')') {
            dfs(index + 1, leftCount, rightCount, leftMove, rightMove, path);
        } else if (c == '(') {
            dfs(index + 1, leftCount + 1, rightCount, leftMove, rightMove, path);
        } else if (leftCount > rightCount) {
            // 保留右括号时，左边大于右边才合法
            dfs(index + 1, leftCount, rightCount + 1, leftMove, rightMove, path);
        }
        path.deleteCharAt(path.length() - 1);
    }
}

