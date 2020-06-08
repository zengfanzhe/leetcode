package com.coding.binarySearch;

public class Q33_searchInRotatedSortedArray {
    public static void main(String[] args) {
        Q33_searchInRotatedSortedArray q33 = new Q33_searchInRotatedSortedArray();
        //System.out.println(q33.search(new int[]{4,5,6,7,0,1,2,3}, 0));//4
       // System.out.println(q33.search(new int[]{7,0,1,2,3}, 0));//1
        System.out.println(q33.search(new int[]{6,7,0,1,2,3}, 0));//2
        /*System.out.println(q33.search(new int[]{5,6,7,0,1,2,3}, 0));//3
        System.out.println(q33.search(new int[]{4,5,6,7,1,2,3}, 0));//-1
        System.out.println(q33.search(new int[]{4,5,6,7,0,1,2}, 0));//4
        System.out.println(q33.search(new int[]{4,5,6,7,0,1}, 0));//4*/
    }

    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        while(end > begin){
            //int mid = (begin + end)/2; // here has a bug.
            int mid = (end - begin)/2 + begin;
            double num = (target < nums[0]) == (nums[mid] < nums[0]) ?
                    nums[mid] : (target < nums[0]) ? -Double.MAX_VALUE : Double.MAX_VALUE;

            if(num > target){
                end = mid;
            }else if(num < target){
                begin = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
