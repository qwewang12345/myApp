package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/25 9:39
 **/
public class Struct124 {

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

    public int maxRes = Integer.MIN_VALUE;
    public int maxLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxLen(root);
        return maxRes;
    }

    public int getMaxLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 获取左右子树上能获取的最大值,负数不取，当0
        int left = Math.max(getMaxLen(root.left), 0);
        int right = Math.max(getMaxLen(root.right), 0);
        int len = left + right + root.val;
        maxRes = Math.max(len, maxRes);
        return len;
    }


}
