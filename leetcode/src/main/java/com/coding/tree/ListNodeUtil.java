package com.coding.tree;

public class ListNodeUtil {
    public static ListNode convertNum2ListNode(int[] nums) {
        ListNode node = new ListNode(0);
        ListNode dupHead = node;
        for (int i : nums){
            node.next = new ListNode(i);
            node = node.next;
        }
        return dupHead.next;
    }
}
