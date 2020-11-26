package com.coding.tree;

public class Q538_ConvertBSTtoGreaterTree {

    public static void main(String[] args) {
        Q538_ConvertBSTtoGreaterTree q538 = new Q538_ConvertBSTtoGreaterTree();
        //[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
        // 30,36,21,36,35,26,15,null,null,null,33,null,null,null,8
        TreeNode root = TreeUtil.convertNum2Tree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        root = q538.convertBST(root);
        TreeUtil.printTree(root);
    }

    public TreeNode convertBST(TreeNode root) {
        return helper(root, new TreeNode(0));
    }

    private TreeNode helper(TreeNode node, TreeNode maxValue) {
        if (node == null)
            return null;
        helper(node.right, maxValue);
        node.val += maxValue.val;
        maxValue.val = node.val;
        helper(node.left, maxValue);
        return node;
    }

}
