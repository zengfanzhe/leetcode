package com.coding.tree;

public class Q230_kthSmallestElementInABST {
    public static void main(String[] args) {
        Q230_kthSmallestElementInABST q230 = new Q230_kthSmallestElementInABST();
        /**
         *         4
         *      2     5
         *    1  3
         */

        TreeNode root = new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(q230.kthSmallest(root, 5));
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            throw new IllegalArgumentException("root can't be null.");

        int leftSum = getSum(root.left);
        if(k == leftSum + 1)
            return root.val;
        if(leftSum >= k)
            return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - leftSum - 1);

    }

    private int getSum(TreeNode node) {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        int left = getSum(node.left);
        int right = getSum(node.right);
        return left+right+1;
    }
}
