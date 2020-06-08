package com.coding.breadthFirstSearch;

import com.coding.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q111_minimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Q111_minimumDepthOfBinaryTree q111 = new Q111_minimumDepthOfBinaryTree();


        /**
         *      3
         *    9   20
         *      15   7
         *    4     1
         *     6
         */
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        root.right.left.left=new TreeNode(4);
        root.right.left.right=new TreeNode(6);
        root.right.right.left=new TreeNode(1);

        System.out.println(q111.minDepth(root));


    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(root);
        q2.add(1);
        while(!q1.isEmpty()){
            TreeNode node = q1.poll();
            int level = q2.poll();
            if (node.left == null && node.right == null){
                return level;
            }else {
                if(node.left != null){
                    q1.add(node.left);
                    q2.add(level+1);
                }

                if(node.right != null){
                    q1.add(node.right);
                    q2.add(level+1);
                }
            }
        }

        throw new IllegalStateException();
    }

    //approach 1:
    public int minDepth1(TreeNode root) {
        if (root == null)
            return 0;

        int res = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 1));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            TreeNode treeNode = node.treeNode;
            if (treeNode.left == null && treeNode.right == null){
                res = node.level;
                break;
            }else {
                if(treeNode.left != null)
                   queue.add(new Node(treeNode.left, node.level+1));

                if(treeNode.right != null)
                    queue.add(new Node(treeNode.right, node.level+1));
            }
        }
        return res;
    }

    class Node{
        TreeNode treeNode;
        int level;

        public Node(TreeNode treeNode, int level){
            this.treeNode = treeNode;
            this.level = level;
        }
    }
}
