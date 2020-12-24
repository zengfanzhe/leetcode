package com.coding.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1019_NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        Q1019_NextGreaterNodeInLinkedList q1019 = new Q1019_NextGreaterNodeInLinkedList();
        ListNode head = convertArr2LinkedList(new int[]{1,7,5,1,9,2,5,1});
        Arrays.stream(q1019.nextLargerNodes(head))
                .forEach(System.out :: print);
    }

    private static ListNode convertArr2LinkedList(int[] arr) {
        ListNode dupHead = new ListNode(0);
        ListNode node = dupHead;
        for (int i : arr){
            node.next = new ListNode(i);
            node = node.next;
        }
        return dupHead.next;
    }



    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arrlist = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            arrlist.add(node.val);
            node = node.next;
        }

        int[] res = new int[arrlist.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arrlist.size(); i++){
            while (!stack.isEmpty() && arrlist.get(stack.peek()) < arrlist.get(i)){
                res[stack.pop()] = arrlist.get(i);
            }
            //放进去的是还没找到下个最大的值的索引
            stack.push(i);
        }
        return res;
    }
}
