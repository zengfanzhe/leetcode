package com.coding.twoPointers;

import java.util.HashMap;

public class Q532_KdiffPairsInAnArray {
    public static void main(String[] args) {
        Q532_KdiffPairsInAnArray q532 = new Q532_KdiffPairsInAnArray();
        System.out.println(q532.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(q532.findPairs(new int[]{1, 2, 3, 4, 5}, -1));
        System.out.println(q532.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
    }

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums){
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        int count = 0;
        if (k == 0){
            for (Integer i : map.values()){
                if (i > 1) count++;
            }
        }else {
            for (Integer i: map.keySet()) {
                if (map.containsKey(i+k)) count++;
            }
        }

        return count;
    }
}
