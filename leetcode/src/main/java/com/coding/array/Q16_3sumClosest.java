package com.coding.array;

public class Q16_3sumClosest {
    public static void main(String[] args) {
        Q16_3sumClosest q16 = new Q16_3sumClosest();
        System.out.println(q16.threeSumClosest(new int[]{-1,6,1,5,4,3}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int[] res = new int[2];
        res[1] = Integer.MAX_VALUE;
        helper(nums, target, 0, 0, 0, res);
        return res[0];
    }

    private void helper(int[] nums, int target, int temp, int index, int depth, int[] res) {
        if(depth >= 3){
            if(res[1] > Math.abs(target - temp)){
                res[1] = Math.abs(target - temp);
                res[0] = temp;
            }
            return;
        }

        for(int i=index; i<nums.length; i++){
            temp+=nums[i];
            helper(nums, target, temp, i+1, depth+1, res);
            temp-=nums[i];
        }
    }
}
