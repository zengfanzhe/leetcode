package com.coding.linkedList;



public class Q19_removeNthNodeFromEndOfList {
    public static void main(String[] args) {
        Q19_removeNthNodeFromEndOfList q19 = new Q19_removeNthNodeFromEndOfList();
        ListNode head,node;
        head = create(new int[]{1,2,3,4,5});
        node = q19.removeNthFromEnd(head,5);
        println(node);

        head = create(new int[]{1,2,3,4,5});
        node = q19.removeNthFromEnd(head,1);
        println(node);

        head = create(new int[]{1,2,3,4,5});
        node = q19.removeNthFromEnd(head,4);
        println(node);

        head = create(new int[]{1,2,3,4,5});
        node = q19.removeNthFromEnd(head,2);
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n<=0)
            return head;

        int length=0;
        ListNode node = head;
        ListNode p = head;
        while(node!=null){
            length++;
            node = node.next;
        }
        int m=length-n;
        if(m<0)
            return null;
        if(m==0)
            head=head.next;
        else{
            while(m>1){
                m--;
                p=p.next;
            }
            p.next=p.next.next;
        }
        return head;
    }

}
