package com.example.demo.service.struct.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author gaonan1
 * @date 2021/5/30 12:45
 **/
public class PreOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        List<Integer> integerList = preorderTraversal(root);
        System.out.println(integerList);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.empty() || root != null) {
            if (!s.empty()) {
                TreeNode h = s.pop();
                res.add(h.val);
            } else {
                if (root.right != null) {
                    s.push(root.right);
                }
                if (root.left != null) {
                    s.push(root.left);
                }
            }
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
