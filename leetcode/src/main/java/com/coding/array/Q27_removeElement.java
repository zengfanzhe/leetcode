package com.coding.array;

public class Q27_removeElement {
    public static void main(String[] args) {
        Q27_removeElement q27 = new Q27_removeElement();
        System.out.println(q27.removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(q27.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(q27.removeElement(new int[]{1,1,1,2}, 1));
        System.out.println(q27.removeElement(new int[]{1}, 1));
        System.out.println(q27.removeElement(new int[]{}, 3));

    }

    //approach 1:
    public int removeElement2(int[] nums, int val) {
        int len = nums.length, index = 0;
        while(index < len){
            if(nums[index] == val){
                for(int j=index; j<len-1; j++) nums[j] = nums[j+1];
                len--;
            }else{
                index++;
            }
        }
        return len;
    }

    //approach 2:
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
