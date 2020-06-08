package com.coding.array;

import java.util.HashSet;

public class Q128_longestConsecutiveSequence {
    public static void main(String[] args) {
        Q128_longestConsecutiveSequence q128 = new Q128_longestConsecutiveSequence();
        System.out.println(q128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2,0}));
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer num : nums)
            set.add(num);

        int longest = 0;
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i]-1)){
                int count=1;
                int temp = nums[i];
                while(set.contains(++temp))
                    count++;

                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
