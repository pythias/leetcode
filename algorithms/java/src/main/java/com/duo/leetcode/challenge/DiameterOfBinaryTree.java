package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;

public class DiameterOfBinaryTree implements Algorithm {
    private int result;
    public int diameterOfBinaryTree(TreeNode root) {
        this.result = -1;
        this.diameter(root);
        return this.result == - 1 ? 0 : (this.result - 1);
    }

    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = this.diameter(root.left);
        int right = this.diameter(root.right);
        int length = left + right + 1;

        this.result = Math.max(this.result, length);

        return 1 + Math.max(left, right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    private TreeNode createNode(Integer[] values) {
        return this.createNode(values, 0, 0);
    }

    private TreeNode createNode(Integer[] values, int index, int level) {
        if (index >= values.length || values[index] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[index]);
        int levelSize = (int)Math.pow(2, level);
        int levelOffset = index - levelSize + 1;
        int left = (levelSize * 2) - 1 + levelOffset * 2;
        root.left = this.createNode(values, left, level + 1);
        root.right = this.createNode(values, left + 1, level + 1);
        return root;
    }

    private void _run(Integer[] values) {
        TreeNode treeNode = this.createNode(values);
        System.out.printf("Diameter of Binary Tree %s, result is %d\n", treeNode, this.diameterOfBinaryTree(treeNode));
    }

    @Override
    public void run() {
        this._run(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    }
}