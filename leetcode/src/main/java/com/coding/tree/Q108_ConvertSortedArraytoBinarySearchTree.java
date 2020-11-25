package com.coding.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q108_ConvertSortedArraytoBinarySearchTree {

    public static void main(String[] args) {
        Q108_ConvertSortedArraytoBinarySearchTree q108 = new Q108_ConvertSortedArraytoBinarySearchTree();
        //0,-3,9,-10,null,5
        //0,-3,9,-10,null,5
        TreeNode node = q108.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        printTree(node);
    }

    private static void printTree(TreeNode node) {
        if (node == null)
            System.out.println("null");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode nodetmp = queue.poll();
            if (nodetmp != null){
                queue.add(nodetmp.left);
                queue.add(nodetmp.right);
                System.out.print(nodetmp.val + ",");
            }else {
                System.out.print("null,");
            }
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int low, int height) {
        if(height <= low)
            return null;

        int mid = low + (height - low)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid);
        node.right = helper(nums, mid+1, height);
        return node;
    }
}
