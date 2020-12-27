package com.coding.binarySearch;

public class Q4_MedianofTwoSortedArrays {
    public static void main(String[] args) {
        Q4_MedianofTwoSortedArrays q4 = new Q4_MedianofTwoSortedArrays();
        System.out.println(q4.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        if (nums1.length > B.length){
            A = nums2;
            B = nums1;
        }

        int min = 0, max = A.length;
        while (min <= max){
            int i = (min + max)/2;
            int j = (A.length + B.length + 1)/2 -i;

            if (i < max && A[i] < B[j-1]){
                min = i + 1;
            }else if(i > min && A[i-1] > B[j]){
                max = i - 1;
            }else {
                int maxLeft = 0;
                int minRight = 0;
                if (i == 0) maxLeft = B[j -1];
                else if(j == 0) maxLeft = A[i-1];
                else maxLeft = Math.max(A[i-1], B[j-1]);

                if ((A.length + B.length)%2 == 1) return maxLeft;

                if (i == A.length) minRight = B[j];
                else if(j == B.length) minRight = A[i];
                else minRight = Math.min(B[j], A[i]);

                return (maxLeft + minRight)/2.0;
            }
        }

        return 0.0;
    }
}
