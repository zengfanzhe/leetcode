package com.coding.design;

import com.coding.tree.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q173_binarySearchTreeIterator {
    public static void main(String[] args) {
        /**
         *      7
         *    3   15
         *       9 20
         */
        TreeNode root = new TreeNode(7);
        root.left=new TreeNode(3);
        root.right=new TreeNode(15);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());    // return 3
        System.out.println(iterator.next());    // return 7
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 9
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 15
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 20
        System.out.println(iterator.hasNext()); // return false
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class BSTIterator {

    //PriorityQueue<Integer> pq = new PriorityQueue<>();
    Queue<Integer> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        helper(root);
    }

    private void helper(TreeNode root) {
        if(root == null)
            return;

        helper(root.left);
        queue.offer(root.val);
        helper(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */