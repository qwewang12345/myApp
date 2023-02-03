package com.example.demo.service.struct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author gaonan1
 * @date 2021/8/20 11:26
 **/
public class Struct102 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> levelTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            long size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}