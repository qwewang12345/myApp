package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/20 11:26
 **/
public class Struct114 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode transferLinkedList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = transferLinkedList(root.left);
        TreeNode right = transferLinkedList(root.right);
        root.left = null;
        if (left != null) {
            root.right = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        } else {
            root.right = right;
        }
        return root;
    }
}