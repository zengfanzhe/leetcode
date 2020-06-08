package com.coding.tree;

public class Q112_pathSum {

    public static void main(String[] args) {
        Q112_pathSum q112 = new Q112_pathSum();
        /**
         *      3
         *    9   20
         *       15 7
         */
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(q112.hasPathSum(root, 30));
        System.out.println(q112.hasPathSum(root, 38));
        System.out.println(q112.hasPathSum(root, 12));
        System.out.println(q112.hasPathSum(root, 23));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left==null && root.right==null && sum == root.val)
            return true;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
