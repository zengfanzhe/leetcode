package com.coding.twoPointers;

public class Q845_LongestMountaininArray {

    public static void main(String[] args) {
        Q845_LongestMountaininArray q845 = new Q845_LongestMountaininArray();
        System.out.println(q845.longestMountain(new int[]{2,1,4,7,3,2,5}));
        System.out.println(q845.longestMountain(new int[]{2,2,2}));
    }

    public int longestMountain(int[] arr) {
        int[] down = new int[arr.length];
        int[] up = new int[arr.length];
        int res = 0;

        for (int i= arr.length-2; i>=0; i--) {
            if (arr[i] > arr[i + 1])
                down[i] = down[i + 1] + 1;
        }

        for (int i = 1; i<arr.length; i++) {
            if (arr[i] > arr[i - 1])
                up[i] = up[i - 1] + 1;

            if (down[i] > 0 && up[i] >0)
                res = Math.max(res, up[i] + down[i] + 1);
        }
        return res;
    }

}
