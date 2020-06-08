package com.coding.heap;

import java.util.PriorityQueue;

public class Q703_kthLargestElementInAStream {

    public static void main(String[] args) {
        int k = 3;
        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        kthLargest.add(3);   // returns 4
        kthLargest.add(5);   // returns 5
        kthLargest.add(10);  // returns 5
        kthLargest.add(9);   // returns 8
        kthLargest.add(4);   // returns 8

    }


}
class KthLargest {
    final  PriorityQueue<Integer> p;
    final  int k;

    public KthLargest(int k, int[] nums) {
        p = new PriorityQueue<>(k);
        this.k = k;
        for (Integer num:nums)
            add(num);
    }

    public int add(int val) {
        if(p.size() < k)
            p.offer(val);
        else if(p.peek() < val){
            p.poll();
            p.offer(val);
        }
        return p.peek();
    }
}