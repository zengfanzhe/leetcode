package com.coding.linkedList;

public class Q83_removeDuplicateFromSortedList {
    public static void main(String[] args) {
        Q83_removeDuplicateFromSortedList q83 = new Q83_removeDuplicateFromSortedList();
        ListNode head;

        head = create(new int[]{1,1,1,1,2,2});
        head=q83.deleteDuplicates(head);
        println(head);

        head = create(new int[]{1,2,3});
        head=q83.deleteDuplicates(head);
        println(head);

        head = create(new int[]{1});
        head=q83.deleteDuplicates(head);
        println(head);

        head = create(new int[]{});
        head=q83.deleteDuplicates(head);
        println(head);
    }

    private static void println(ListNode head){
        while (head!=null){
            System.out.print(head.val);
            head = head.next;
            if(head!=null)
                System.out.print("->");
        }
        System.out.println();
    }

    private static ListNode create(@org.jetbrains.annotations.NotNull int[] ints) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        for(int i=0; i<ints.length; i++){
            p.next = new ListNode(ints[i]);
            p = p.next;
        }
        return dummyHead.next;
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p!=null && p.next!=null){
            if(p.val == p.next.val)
                p.next=p.next.next;
            else
                p=p.next;
        }
        return head;
    }
}
