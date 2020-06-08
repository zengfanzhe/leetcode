package com.coding.array;

public class Q55_jumpGame {
    public static void main(String[] args) {
        Q55_jumpGame q55 = new Q55_jumpGame();
        System.out.println(q55.canJump2(new int[]{2,3,1,1,4}));
        System.out.println(q55.canJump2(new int[]{3,2,1,0,4}));
        System.out.println(q55.canJump2(new int[]{0}));
        System.out.println(q55.canJump2(new int[]{}));
        System.out.println(q55.canJump2(new int[]{6,2}));

    }

    /**
     * approach 1: Backtracking
     */

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        if(nums.length == 1)
            return true;
        boolean[] visited = new boolean[nums.length];
        for (int i=0; i<visited.length; i++)
            visited[i]=false;
        return helper(nums, 0, visited);
    }

    private boolean helper(int[] nums, int index,boolean[] visited) {
        if(index == nums.length-1)
            return true;

        int maxIndex = Math.min(nums[index],nums.length-1);

        for(int i=maxIndex; i>=1; i--){
            if(i+index<nums.length && visited[i+index] == false){
                if(helper(nums, i+index,visited))
                    return true;
            }
        }
        visited[index] = true;
        return false;
    }


    /**
     * approach 2: Dynamic Programming
     */
    public boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;

        boolean[] memo = new boolean[nums.length];
        for(int i=0; i<memo.length; i++)
            memo[i] = false;

        memo[memo.length-1]=true;
        for(int i=nums.length-2; i>=0; i--){
            for(int j=1; j<=nums[i] && i+j<nums.length; j++){
                if(memo[i+j]){
                    memo[i]=true; break;
                }
            }
        }
        return memo[0];
    }
}
