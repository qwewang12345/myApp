package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/30 9:50
 **/
public class Struct226 {

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

    public TreeNode reversalTreeNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = reversalTreeNode(root.left);
        TreeNode right = reversalTreeNode(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
