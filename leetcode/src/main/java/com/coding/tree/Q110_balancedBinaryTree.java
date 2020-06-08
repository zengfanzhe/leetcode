package com.coding.tree;

public class Q110_balancedBinaryTree {
    public static void main(String[] args) {
        //case 1:
        TreeNode root = TreeNode.stringToTreeNode("[1,null,3,12,13]");
        testCase(root, false);

        //case 2:
        root = TreeNode.stringToTreeNode("[]");
        testCase(root, true);

        //case 3:
        root = TreeNode.stringToTreeNode("[1]");
        testCase(root, true);

        //case 4:
        root = TreeNode.stringToTreeNode("[1,2,3]");
        testCase(root, true);

        //case 5:
        root = TreeNode.stringToTreeNode("[1,2,3,4,5]");
        testCase(root, true);


        //case 6：
        root = TreeNode.stringToTreeNode("[1,2,3,4,null,null,5,6,null,null,7]");
        testCase(root, false);

    }

    private static void testCase(TreeNode root, boolean b) {
        Q110_balancedBinaryTree q110 = new Q110_balancedBinaryTree();
        if(q110.isBalanced(root) != b){
            throw new RuntimeException();
        }
    }


    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        int leftL = getLength(root.left);
        int rightL = getLength(root.right);
        if(Math.abs(leftL-rightL) > 1 || !isBalanced(root.right) || !isBalanced(root.left)){
            return false;
        }
        return true;
    }

    private int getLength(TreeNode root) {
        if(root == null)
            return 0;

        int leftL = getLength(root.left);
        int rightL = getLength(root.right);

        return ((leftL > rightL) ? leftL : rightL) + 1;
    }
}
