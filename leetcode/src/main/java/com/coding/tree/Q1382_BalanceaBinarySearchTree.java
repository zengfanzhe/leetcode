package com.coding.tree;


public class Q1382_BalanceaBinarySearchTree {

    public static void main(String[] args) {
        Q1382_BalanceaBinarySearchTree q1382 = new Q1382_BalanceaBinarySearchTree();
        TreeNode node = TreeUtil.convertNum2Tree(new Integer[]{1,null,2,null,3,null,4,null,null});
        TreeUtil.printTree(node);
        TreeNode balanceTree = q1382.balanceBST(node);
        TreeUtil.printTree(balanceTree);
    }

    public TreeNode balanceBST(TreeNode root) {
        java.util.List<Integer> list = convert2SortedList(root);
        return balanceBST(list);
    }

    private TreeNode balanceBST(java.util.List<Integer> nums) {
        return helper(nums, 0, nums.size());
    }

    private TreeNode helper(java.util.List<Integer> nums, int low, int height) {
        if (height <= low)
            return null;

        int mid = low + (height - low)/2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = helper(nums, low, mid);
        node.right = helper(nums, mid+1, height);
        return node;
    }

    private java.util.List<Integer> convert2SortedList(TreeNode root) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, java.util.List<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
