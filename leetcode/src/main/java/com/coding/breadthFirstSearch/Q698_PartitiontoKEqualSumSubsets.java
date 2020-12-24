package com.coding.breadthFirstSearch;

public class Q698_PartitiontoKEqualSumSubsets {
    public static void main(String[] args) {
        Q698_PartitiontoKEqualSumSubsets q698 = new Q698_PartitiontoKEqualSumSubsets();
        System.out.println(q698.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(q698.canPartitionKSubsets(new int[]{10,10,10,7,7,7,7,7,7,6,6,6}, 3));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = java.util.Arrays.stream(nums).sum();
        if (sum % k != 0)
            return false;
        int target = sum / k;
        return helper(nums, target, new int[k], 0);
    }

    private boolean helper(int[] nums, int target, int[] group, int index) {
        if (index >= nums.length)
            return true;

        for (int i=0; i<group.length; i++){
            if (group[i] + nums[index] <= target){
                group[i] += nums[index];
                if (helper(nums, target, group, index+1))
                    return true;
                group[i] -= nums[index];
            }
        }
        return false;
    }


}
