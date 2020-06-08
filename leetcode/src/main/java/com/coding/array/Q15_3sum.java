package com.coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q15_3sum {
    public static void main(String[] args) {
        Q15_3sum q15 = new Q15_3sum();
        List<List<Integer>> res;
        res = q15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        printResult(res);

        res = q15.threeSum(new int[]{-1});
        printResult(res);

        res = q15.threeSum(new int[]{-2,0,1,1,2});
        printResult(res);

        res = q15.threeSum(new int[]{0,0,0,0});
        printResult(res);

    }

    private static void printResult(List<List<Integer>> res) {
        for(int i=0; i<res.size(); i++){
            for(int j=0; j<res.get(i).size(); j++)
                System.out.print(res.get(i).get(j)+" ");
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2 && nums[i]<=0 ;i++){
           for(int j=i+1; j<nums.length-1; j++){
               int key = 0 - (nums[i] + nums[j]);
               int index = binarySearch(nums, j+1, nums.length-1, key);
               if(index != -1)
                   res.add(Arrays.asList(nums[i], nums[j], nums[index]));
               while(j+1 < nums.length-1 && nums[j] == nums[j+1]) j++;
           }
            while(i+1 < nums.length-2 && nums[i] == nums[i+1]) i++;
        }

        return res;
    }

    private int binarySearch(int[] nums, int low, int high, int key) {
        while(high >= low){
            int mid = (high - low)/2 + low;
            if(nums[mid] == key){
                return mid;
            }else if(nums[mid] > key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
