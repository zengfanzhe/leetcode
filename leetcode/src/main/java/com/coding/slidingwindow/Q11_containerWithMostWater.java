package com.coding.slidingwindow;

public class Q11_containerWithMostWater {

    public static void main(String[] args) {
        Q11_containerWithMostWater q11 = new Q11_containerWithMostWater();
        System.out.println(q11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxArea = 0;
        while(i < j){
            int tmp =  (height[i] > height[j] ? height[j] : height[i]) * (j-i);
            maxArea = tmp > maxArea ? tmp : maxArea;
            if(height[i] < height[j]) i++; else j--;
        }
        return maxArea;
    }

}
