package duo.leetcode.p872;

import java.util.ArrayList;

class TreeNode { 
    int val; 
    TreeNode left; 
    TreeNode right; 
    TreeNode(int x) { val = x; } 
}

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leafs1 = new ArrayList<Integer>();
        this.getLeafs(root1, leafs1);

        ArrayList<Integer> leafs2 = new ArrayList<Integer>();
        this.getLeafs(root2, leafs2);

        if (leafs1.size() != leafs2.size()) {
            return false;
        }

        for (int i = 0; i < leafs1.size(); i++) {
            if (leafs1.get(i) != leafs2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void getLeafs(TreeNode root, ArrayList<Integer> leafs) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            this.getLeafs(root.left, leafs);
        }
        
        if (root.right != null) {
            this.getLeafs(root.right, leafs);
        } 
        
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        }
    }
}