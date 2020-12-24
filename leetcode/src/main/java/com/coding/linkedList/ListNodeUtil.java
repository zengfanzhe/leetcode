package com.coding.linkedList;

import java.util.ArrayList;

public class ListNodeUtil {
    public static ListNode convertArr2LinkedList(int[] arr) {
        ListNode dupHead = new ListNode(0);
        ListNode node = dupHead;
        for (int i : arr){
            node.next = new ListNode(i);
            node = node.next;
        }
        return dupHead.next;
    }

    public static ArrayList<Integer> convertLinkedList2Arr(ListNode head) {
        ArrayList<Integer> arrlist = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            arrlist.add(node.val);
            node = node.next;
        }
        return arrlist;
    }
}
