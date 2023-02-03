package com.example.demo.service.struct;

import org.apache.dubbo.common.utils.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaonan1
 * @date 2021/8/20 11:26
 **/
public class Struct94 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void midTraverse1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);
                root = node.right;
            }
        }
    }

    public void midTraverse(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
    }

    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
