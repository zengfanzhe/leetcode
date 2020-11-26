package com.coding.tree;

import java.util.Map;

public class Q1367_LinkedListinBinaryTree {

    public static void main(String[] args) {
        Q1367_LinkedListinBinaryTree q1367 = new Q1367_LinkedListinBinaryTree();

        //case 1
        TreeNode root = TreeUtil.convertNum2Tree(new Integer[]{1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3});
        ListNode head = ListNodeUtil.convertNum2ListNode(new int[]{4,2,8});
       System.out.println(q1367.isSubPath(head, root));

        //case 2
        TreeNode root2 = TreeUtil.convertNum2Tree(new Integer[]{1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3});
        ListNode head2 = ListNodeUtil.convertNum2ListNode(new int[]{1,4,2,6,8});
        System.out.println(q1367.isSubPath(head2, root2));

    }


    // Time Limit Exceeded
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null)
            return true;

        if (root == null)
            return false;

        boolean b1 = false, b2;
        if (head.val == root.val){
            b1 = isSubPath(head.next, root.left)
                    || isSubPath(head.next, root.right);
        }
        b2 = isSubPath(head, root.left)
                    || isSubPath(head, root.right);

        return b1 || b2;
    }

}
