package com.coding.tree;

public class Q100_sameTree {
    public static void main(String[] args) {
        Q100_sameTree q100 = new Q100_sameTree();
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


        TreeNode root1 = new TreeNode(3);
        root1.left=new TreeNode(9);
        root1.right=new TreeNode(20);
        root1.right.left=new TreeNode(15);

        System.out.println(q100.isSameTree(root, root1));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p != null && q == null || p == null && q != null)
            return false;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
