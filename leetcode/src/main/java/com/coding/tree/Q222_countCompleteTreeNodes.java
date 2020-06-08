package com.coding.tree;

public class Q222_countCompleteTreeNodes {
    public static void main(String[] args) {
        Q222_countCompleteTreeNodes q222 = new Q222_countCompleteTreeNodes();
        /**
         *      3
         *    9   20
         *  15 7
         */
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.left.left=new TreeNode(15);
        root.left.right=new TreeNode(7);

        System.out.println(q222.countNodes(root));

    }

    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        int h = getHeight(root);
        int h_right=getHeight(root.right);
        return h==h_right+1?(int)Math.pow(2,h_right)+countNodes(root.right):
                (int)Math.pow(2,h_right)+countNodes(root.left);
    }

    private int getHeight(TreeNode node) {
        int level=0;
        while(node!=null){
            level++;
            node = node.left;
        }
        return level;
    }
}
