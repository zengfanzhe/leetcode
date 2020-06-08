package com.coding.linkedList;

public class Q82_removeDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        Q82_removeDuplicatesFromSortedList2 q82 = new Q82_removeDuplicatesFromSortedList2();
        ListNode head;

        head = create(new int[]{1,1,1,1,2,2});
        head=q82.deleteDuplicates(head);
        println(head);

        head = create(new int[]{1,2,3});
        head=q82.deleteDuplicates(head);
        println(head);

        head = create(new int[]{1});
        head=q82.deleteDuplicates(head);
        println(head);

        head = create(new int[]{1,1,1});
        head=q82.deleteDuplicates(head);
        println(head);

        head = create(new int[]{1,2,3,3,4,4,5});
        head=q82.deleteDuplicates(head);
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
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while(cur != null){
            if(cur.next != null && cur.next.next != null){
                if(cur.next.val == cur.next.next.val){
                    ListNode temp = cur.next;
                    while(temp.next != null && temp.val == temp.next.val){
                        temp = temp.next;
                    }
                    cur.next = temp.next;
                    continue;
                }
            }
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
