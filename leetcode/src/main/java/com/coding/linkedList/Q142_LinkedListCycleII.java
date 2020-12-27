package com.coding.linkedList;

public class Q142_LinkedListCycleII {
    public static void main(String[] args) {
        Q142_LinkedListCycleII q142 = new Q142_LinkedListCycleII();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        ListNode res = q142.detectCycle(n6);
        System.out.println(res.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast!=null && fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }

            slow = slow.next;
        }while (fast != slow);

        slow = head;

        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
