package com.example.demo.service.struct;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author gaonan1
 * @date 2021/8/20 11:26
 **/
public class Struct105 {

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

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        int val = preorder[preStart];
        // 只剩一个元素时，不用再执行下面，直接构造节点即可
        if (preEnd - preStart == 0) {
            return new TreeNode(val, null, null);
        }
        int index = indexMap.get(val);
        // 递归分别获取左右节点
        // 不包含index，不用再减1
        int leftLen = index - inStart;
        TreeNode left = myBuildTree(preorder, inorder,preStart + 1, preStart + leftLen, inStart, index - 1);
        int rightLen = inEnd - index;
        TreeNode right = myBuildTree(preorder, inorder, preEnd - rightLen + 1, preEnd, index + 1, inEnd);
        return new TreeNode(val, left, right);
    }
}