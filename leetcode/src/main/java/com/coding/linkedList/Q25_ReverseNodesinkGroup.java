package com.coding.linkedList;

import java.util.Arrays;

public class Q25_ReverseNodesinkGroup {
    public static void main(String[] args) {
        Q25_ReverseNodesinkGroup q25 = new Q25_ReverseNodesinkGroup();
        ListNode head = ListNodeUtil.convertArr2LinkedList(new int[]{1,2,3,4,5,6,7,8});
        ListNode node = q25.reverseKGroup(head, 2);
        ListNodeUtil.convertLinkedList2Arr(node)
                .forEach(System.out :: print);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prenode = null;
        ListNode node = head;
        int kt = k;
        while (node != null && kt > 0){
            prenode = node;
            node = node.next;
            kt--;
        }
        if (kt==0 && node != null){
            reverse(head, k);
            head.next = reverseKGroup(node, k);
            return prenode;
        }else if(kt==0 && node == null){
            reverse(head, k);
            return prenode;
        } else {
            return head;
        }
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode p1 = null;
        ListNode p2 = head;
        int count = 0;
        while(p2 != null && count < k){
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
            count++;
        }
        return p1;
    }
}
