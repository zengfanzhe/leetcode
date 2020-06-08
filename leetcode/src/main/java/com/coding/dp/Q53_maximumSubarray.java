package com.coding.dp;

public class Q53_maximumSubarray {
    public static void main(String[] args) {
        Q53_maximumSubarray q53 = new Q53_maximumSubarray();
        System.out.println(q53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(q53.maxSubArray(new int[]{3}));
        System.out.println(q53.maxSubArray(new int[]{}));
    }

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
