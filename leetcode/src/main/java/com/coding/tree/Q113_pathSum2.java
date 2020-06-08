package com.coding.tree;

import java.util.LinkedList;
import java.util.List;

public class Q113_pathSum2 {

    public static void main(String[] args) {
        Q113_pathSum2 q113 = new Q113_pathSum2();
        /**
         *       3
         *     9   20
         *  18  0 15 7
         */
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.left.left=new TreeNode(18);
        root.left.right=new TreeNode(0);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(q113.pathSum(root, 30));
        System.out.println(q113.pathSum(root, 38));
        System.out.println(q113.pathSum(root, 12));
        System.out.println(q113.pathSum(root, 23));
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new LinkedList<>();
        helper(root,sum,new LinkedList<Integer>(),lists);
        return lists;
    }

    private void helper(TreeNode root, int sum, LinkedList<Integer> temp, List<List<Integer>> lists) {
        if(root == null)
            return;
        temp.add(root.val);
        if(root.left==null && root.right==null && root.val==sum){
            lists.add(new LinkedList<Integer>(temp));
        }

        helper(root.left,sum-root.val,temp,lists);
        helper(root.right,sum-root.val,temp,lists);
        temp.removeLast();
    }
}
