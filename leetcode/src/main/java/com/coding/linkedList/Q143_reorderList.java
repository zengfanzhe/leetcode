package com.coding.linkedList;

public class Q143_reorderList {
    public static void main(String[] args) {
        Q143_reorderList q143 = new Q143_reorderList();
        ListNode head;
        head = create(new int[]{1,2,3,4,5});
        q143.reorderList(head);
        println(head);

        head = create(new int[]{});
        q143.reorderList(head);
        println(head);

        head = create(new int[]{1,2,3,4,5,6});
        q143.reorderList(head);
        println(head);

        head = create(new int[]{1});
        q143.reorderList(head);
        println(head);

        head = create(new int[]{1,2});
        q143.reorderList(head);
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

    private static ListNode create(int[] ints) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        for(int i=0; i<ints.length; i++){
            p.next = new ListNode(ints[i]);
            p = p.next;
        }
        return dummyHead.next;
    }

    public void reorderList(ListNode head) {
        ListNode p = head;
        while(p!=null){
            ListNode temp = reverse(p.next);
            p.next=temp;
            p=p.next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode cur=null, pre=head,temp;
        while(pre!=null){
            temp=pre.next;
            pre.next=cur;
            cur=pre;
            pre=temp;
        }
        return cur;
    }
}
