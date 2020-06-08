package com.coding.tree;

import java.util.LinkedList;
import java.util.List;

public class Q129_sumRootToLeafNumbers {

    public static void main(String[] args) {
        /**
         *      4
         *    9   0
         *   5 1
         *
         */
        TreeNode root = new TreeNode(4);
        root.left=new TreeNode(9);
        root.right=new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);



        Q129_sumRootToLeafNumbers q129 = new Q129_sumRootToLeafNumbers();
        System.out.println(q129.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        helper(root, 0, list);
        int sum=0;
        for (Integer num : list) {
            sum+=num;
        }
        return sum;
    }

    private void helper(TreeNode node, int temp, List<Integer> list) {
        if(node == null)
            return;

        temp = temp*10+node.val;
        if(node.left == null && node.right == null){
            list.add(temp);
            return;
        }


        helper(node.left, temp, list);
        helper(node.right, temp, list);
    }
}
