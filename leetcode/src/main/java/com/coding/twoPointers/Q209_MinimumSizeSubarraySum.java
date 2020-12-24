package com.coding.twoPointers;

public class Q209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Q209_MinimumSizeSubarraySum q209 = new Q209_MinimumSizeSubarraySum();
        System.out.println(q209.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        boolean isRun = false;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            while (s <= sum && i>=left){
                isRun = true;
                min = min > (i-left+1) ? (i-left+1) : min;
                sum-=nums[left++];
            }
        }
        return isRun ? min : 0;
    }
}
