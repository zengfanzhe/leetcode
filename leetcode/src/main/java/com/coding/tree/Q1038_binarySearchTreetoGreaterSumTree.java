package com.coding.tree;

public class Q1038_binarySearchTreetoGreaterSumTree {


    public TreeNode bstToGst(TreeNode root) {
        return helper(root, new TreeNode(0));
    }

    private TreeNode helper(TreeNode root, TreeNode sum) {
        if (root.right != null)
            helper(root.right, sum);

        sum.val += root.val;
        root.val = sum.val;

        if (root.left != null)
            helper(root.left, sum);

        return root;
    }

}
