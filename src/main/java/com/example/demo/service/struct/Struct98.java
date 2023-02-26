package com.example.demo.service.struct;

import org.apache.dubbo.common.utils.Stack;

/**
 * @author gaonan1
 * @date 2021/8/20 11:26
 **/
public class Struct98 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isValidTree(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, int floor, int ceil) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (val <= floor || val >= ceil) {
            return false;
        }
        return dfs(node.left, floor, val) && dfs(node.right, val, ceil);
    }

    private boolean midOrder(TreeNode root) {
        int pre = Integer.MAX_VALUE;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            TreeNode node = s.pop();
            if (node.val <= pre) {
                return false;
            }
            pre = node.val;
            root = node.right;
        }
        return true;
    }
}