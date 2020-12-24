package com.coding.geek;

import java.util.*;

public class QHeap {

    public static void main(String[] args) {
        List<Integer> list = kLargest(new int[]{ 11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 }, 12, 3);

        for (Integer num : list){
            System.out.print(num + " ");
        }
    }

    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0; i<k; i++){
            minHeap.add(arr[i]);
        }

        for (int i=k; i<arr.length; i++){
            if (minHeap.peek() > arr[i])
                continue;

            minHeap.poll();
            minHeap.add(arr[i]);
        }
        ArrayList<Integer> res = new ArrayList<>(k);
        while (!minHeap.isEmpty()){
           res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }

}
