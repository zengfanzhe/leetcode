package com.coding.linkedList;

public class Q92_reverseLinkedList2 {

    public static void main(String[] args) {
        Q92_reverseLinkedList2 q92 = new Q92_reverseLinkedList2();
        ListNode head,node;
        head = create(new int[]{1,2,3,4,5});
        node = q92.reverseBetween(head,2,4);
        println(node);

        head = create(new int[]{1,2,3,4,5});
        node = q92.reverseBetween(head,1,5);
        println(node);

        head = create(new int[]{1,2,3,4,5});
        node = q92.reverseBetween(head,1,2);
        println(node);

        head = create(new int[]{1,2,3,4,5});
        node = q92.reverseBetween(head,2,2);
        println(node);

        head = create(new int[]{1,2,3,4,5});
        node = q92.reverseBetween(head,1,1);
        println(node);

        head = create(new int[]{1,2,3,4,5});
        node = q92.reverseBetween(head,5,5);
        println(node);

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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next=head;
        ListNode tempP = dummyHead, prePm,postPn;
        int tmp = m-1;

        while(tmp>0){
            tempP=tempP.next;
            tmp--;
        }
        prePm=tempP;
        tempP=prePm.next;
        int length_m_to_n=n-m;
        while(length_m_to_n>0){
            tempP=tempP.next;
            length_m_to_n --;
        }
        postPn=tempP.next;
        tempP.next=null;
        ListNode node=reverse(prePm.next);
        prePm.next.next=postPn;
        prePm.next=node;
        return dummyHead.next;
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
