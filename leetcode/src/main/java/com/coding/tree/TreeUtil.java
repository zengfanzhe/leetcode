package com.coding.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    public static void printTree(TreeNode node) {
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
        System.out.println();
    }


    public static TreeNode convertNum2Tree(Integer[] nums){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(nums[0]);
        TreeNode root = node;
        queue.add(node);

        int i=0;
        while(i<nums.length){
           node =queue.poll();
           ++i;
           if(i<nums.length && nums[i] != null){
               node.left = new TreeNode(nums[i]);
               queue.add(node.left);
           }

           ++i;
           if (i<nums.length && nums[i] != null){
               node.right = new TreeNode(nums[i]);
               queue.add(node.right);
           }
        }
        return root;
    }
}
