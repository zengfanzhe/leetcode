package com.coding.linkedList;

import java.util.HashSet;

public class Q141_linkedListCycle {
    public static void main(String[] args) {

        Q141_linkedListCycle q141 = new Q141_linkedListCycle();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println(q141.hasCycle(node1));
        //1-2-3-4-5-3
        node5.next=node3;

        System.out.println(q141.hasCycle(node1));

    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node !=null){
            if(set.contains(node))
                return true;
            set.add(node);
            node=node.next;
        }
        return false;
    }
}
