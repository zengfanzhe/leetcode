package com.coding.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q654_maximumBinaryTree {

    public static void main(String[] args) {
        Q654_maximumBinaryTree q654 = new Q654_maximumBinaryTree();

        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode root = q654.constructMaximumBinaryTree(nums);
        System.out.println(root.left.val);
        printByLevelOrderTraversal(root);
    }

    private static void printByLevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                System.out.print("# ");
                continue;
            }
            System.out.print(node.val + " ");
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    /**
     *
     * @param nums
     * @param beginIndex    the beginning index, inclusive
     * @param endIndex      the ending index, exclusive
     * @return
     */
    private TreeNode helper(int[] nums, int beginIndex, int endIndex) {
        int index = getArrMax(nums, beginIndex, endIndex);
        if(index == -1)
            return null;
        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(nums, beginIndex, index);
        node.right = helper(nums, index+1, endIndex);
        return node;
    }

    /**
     *
     * @param nums
     * @param beginIndex    the beginning index, inclusive
     * @param endIndex      the ending index, exclusive
     * @return
     */
    private int getArrMax(int[] nums, int beginIndex, int endIndex) {
        int index = -1;

        if((endIndex - beginIndex) <= 0 || nums.length < endIndex)
            return index;

        int max = Integer.MIN_VALUE;
        for(int i=beginIndex; i<endIndex; i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
