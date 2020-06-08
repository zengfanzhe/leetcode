package com.coding.recursion;

import com.coding.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q687_longestUnivaluePath {

    public static void main(String[] args) {
        /**
         *      3
         *    9   20
         *       15 7
         */
        TreeNode root = new TreeNode(20);
        root.left=new TreeNode(20);
        root.right=new TreeNode(1);
        root.right.left=new TreeNode(2);
        root.right.right=new TreeNode(20);

        Q687_longestUnivaluePath q687 = new Q687_longestUnivaluePath();
        System.out.println(q687.longestUnivaluePath(root));
    }

    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        this.ans = 0;
        longestUnivaluePathHelper(root);
        return this.ans;
    }

    private int longestUnivaluePathHelper(TreeNode root) {
        if(root == null)
            return 0;

        int left = longestUnivaluePathHelper(root.left);
        int right = longestUnivaluePathHelper(root.right);

        int tempLeft = 0,  tempRight = 0;
        if(root.left != null && root.val == root.left.val)
            tempLeft = left + 1;

        if(root.right != null && root.val == root.right.val)
            tempRight = right + 1;

        this.ans = Math.max(this.ans, tempLeft + tempRight);

        return Math.max(tempLeft, tempRight);
    }

    //[5,4,5,4,4,5,3,4,4,null,null,null,4,null,null,4,null,null,4,null,4,4,null,null,4,4]
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
