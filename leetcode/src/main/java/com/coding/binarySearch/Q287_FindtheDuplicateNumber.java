package com.coding.binarySearch;

import java.util.HashSet;

public class Q287_FindtheDuplicateNumber {
    public static void main(String[] args) {
        Q287_FindtheDuplicateNumber q278 = new Q287_FindtheDuplicateNumber();
        System.out.println(q278.findDuplicate(new int[]{1,3,4,2,2}));
    }

    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : nums){
            if(set.contains(num))
                return num;
            else set.add(num);
        }

        throw new IllegalArgumentException();
    }
}
