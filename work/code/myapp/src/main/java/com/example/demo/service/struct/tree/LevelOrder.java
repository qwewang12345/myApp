package com.example.demo.service.struct.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author gaonan
 * @date 2022/7/18 下午10:02
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        List<List<Integer>> res = levelOrder(node1);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            long size = q.size();
            List<Integer> level = new ArrayList<>();
            // 取出队列中当前有的元素
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                // 子节点放到下一层
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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
