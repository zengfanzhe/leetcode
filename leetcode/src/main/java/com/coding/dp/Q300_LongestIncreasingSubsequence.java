package com.coding.dp;


public class Q300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Q300_LongestIncreasingSubsequence q300 = new Q300_LongestIncreasingSubsequence();
        System.out.println(q300.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(q300.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(q300.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[dp.length-1] = 1;
        int max = dp[dp.length-1];
        for (int i=nums.length-2; i>=0; i--){
            dp[i] = max(dp, nums,i, dp.length) + 1;
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

    private int max(int[] dp, int[] nums, int index, int end) {
        int max = 0;
        for (int i=index+1; i<end; i++){
            if (nums[index] < nums[i] && dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
