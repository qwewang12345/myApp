package com.example.demo.service.struct;

import org.apache.dubbo.common.utils.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gaonan1
 * @date 2021/8/20 11:26
 **/
public class Struct101 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSymmetryTree(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        // 左节点的左子树和右节点的右子树比较，递归一直拿到两者的节点
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public boolean isSymmetryTree1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
}