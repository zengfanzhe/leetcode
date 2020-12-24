package com.coding.recursion;

public class Q410_splitArrayLargestSum {

   /* public static void main(String[] args) {
        Q410_splitArrayLargestSum q410 = new Q410_splitArrayLargestSum();

    }

    public int splitArray(int[] nums, int m) {
        return splitArray(nums, m , 0, nums.length-1);
    }

    private int splitArray(int[] nums, int m, int begin, int end) {
        if(end - begin < m){
            return -1;
        }

        int res = -1;
        for (int i=begin; i<=end; i++){
            int tmp = getSumBef(begin, i, nums);
            int minMax = splitArray(nums, m-1, i+1, end);

            if (minMax == -1){
                break;
            }

            int max = tmp > minMax ? tmp : minMax;
            if (res == -1){
                res = max;
            }else{
                res = max > res ? res : max;
            }
        }
        return res;
    }

    private int getSumBef(int i, int i1, int[] nums) {
    }*/
}
