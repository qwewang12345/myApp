package com.example.demo.service.struct;

/**
 * @author gaonan
 * @date 2022/8/12 下午8:33
 */
public class DictTree {
    public static void main(String[] args) {
        DictTreeNode root = new DictTreeNode();
        insert("ab", root);
        insert("ab", root);
        insert("abc", root);
        int count = find("ab", root);
        System.out.println(count);
    }

    public static void insert(String s, DictTreeNode temp) {
        DictTreeNode root = temp;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            DictTreeNode oldNode = root.childTreeNodes[c - 'a'];
            if (oldNode != null) {
                if (!(i == charArray.length - 1 && oldNode.isEnd)) {
                    oldNode.count++;
                }
                root = oldNode;
            } else {
                DictTreeNode newNode = new DictTreeNode();
                root.childTreeNodes[c - 'a'] = newNode;
                root = newNode;
            }
        }
        root.isEnd = true;
    }

    public static int find(String prefix, DictTreeNode temp) {
        DictTreeNode root = temp;
        char[] prefixArray = prefix.toCharArray();
        for (char p : prefixArray) {
            DictTreeNode treeNode = root.childTreeNodes[p - 'a'];
            if (treeNode == null) {
                return 0;
            }
            root = treeNode;
        }
        return root.count;
    }

    static class DictTreeNode {
        DictTreeNode[] childTreeNodes;
        boolean isEnd;
        int count;
        DictTreeNode () {
            this.childTreeNodes = new DictTreeNode[26];
            this.count = 1;
            this.isEnd = false;
        }
    }
}
