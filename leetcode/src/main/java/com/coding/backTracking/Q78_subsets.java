package com.coding.backTracking;

import java.util.LinkedList;
import java.util.List;




public class Q78_subsets {
    public static void main(String[] args) {
        Q78_subsets q78 = new Q78_subsets();
        List<List<Integer>> result = null;
        result = q78.subsets(new int[]{2,3,1});
        print(result);
    }

    private static void print(List<List<Integer>> result) {
        for(List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num + ",");
            }
            System.out.println("............");
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result, nums, 0, new LinkedList<Integer>());
        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, int i, LinkedList<Integer> tempList) {
        result.add(new LinkedList<>(tempList));
        for(int k=i; k<nums.length; k++){
            tempList.add(nums[k]);
            helper(result, nums, k+1, tempList);
            tempList.removeLast();
        }
    }
}
