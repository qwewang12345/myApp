package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/2 10:07
 **/
public class StructAncestor {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {

    }

    public TreeNode getLeastAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 隐藏了一个节点是另一个节点的子节点的情况，因为条件里面说p,q一定在树中
        // 所以直接返回最先命中的节点也没问题
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = getLeastAncestor(root.left, p, q);
        TreeNode right = getLeastAncestor(root.right, p, q);
        // 左右分支都有
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    private TreeNode ans;
    public TreeNode getLeastAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    /**
     * 判断节点root节点及其子节点，是否有p,q目标节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        // 左右分支都能找到目标节点，或者左右两边找到一个，自身是一个
        if ((left && right) || ((left || right) && (root == p || root == q))) {
            ans = root;
            return true;
        }
        // 左右节点为true或者当前节点是其中的节点，都返回true
        return left || right || root == p || root == q;
    }
}
