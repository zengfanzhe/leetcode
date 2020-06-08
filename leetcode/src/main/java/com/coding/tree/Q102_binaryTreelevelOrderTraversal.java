package com.coding.tree;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q102_binaryTreelevelOrderTraversal {

    public static void main(String[] args) {
        Q102_binaryTreelevelOrderTraversal q102 = new Q102_binaryTreelevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        List<List<Integer>> lists=q102.levelOrder(root);
        print(lists);
    }

    private static void print(List<List<Integer>> lists) {
        for(int i=0; i<lists.size(); i++){
            for(int j=0; j<lists.get(i).size(); j++){
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if(root==null) {
            return lists;
        }
        Deque<Entry> queue = new LinkedList<>();
        queue.add(new Entry(root,0));
        while(!queue.isEmpty()){
            Entry entry = queue.pollFirst();
            int index = (Integer) entry.value;
            TreeNode node = (TreeNode) entry.key;
            if(index == lists.size()){
                lists.add(new LinkedList<Integer>());
            }
            List<Integer> ls = lists.get(index);
            ls.add(node.val);
            if(node.left!=null)
                 queue.add(new Entry(node.left,index+1));
            if(node.right!=null)
                queue.add(new Entry(node.right, index+1));
        }
        return lists;
    }
    class Entry{
        public Object key;
        public Object value;

        public Entry(Object key, Object value){
            this.key=key;
            this.value=value;
        }
    }
}
