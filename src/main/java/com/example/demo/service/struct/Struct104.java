package com.example.demo.service.struct;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gaonan1
 * @date 2021/8/20 11:26
 **/
public class Struct104 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxDepth(root.left) + 1;
        int right = getMaxDepth(root.right) + 1;
        return Math.max(left, right) + 1;
    }

    public int getMaxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxDepth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

}