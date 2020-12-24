package com.coding.math;

import java.util.Arrays;

public class Q1497_CheckIfArrayPairsAreDivisiblebykCheckIfArrayPairsAreDivisiblebyk {
    public static void main(String[] args) {
        Q1497_CheckIfArrayPairsAreDivisiblebykCheckIfArrayPairsAreDivisiblebyk q1497 = new Q1497_CheckIfArrayPairsAreDivisiblebykCheckIfArrayPairsAreDivisiblebyk();
        System.out.println(q1497.canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5));
    }

    public boolean canArrange2(int[] arr, int k) {
        int[] f = new int[k];
        for (int n : arr){
            n%=k;
            if (n < 0)
                n+=k;
            f[n]++;
        }
        if (f[0]%2 != 0)
            return false;
        for (int i=1; i<=k/2; i++){
            if (f[i] != f[k-i])
                return false;
        }
        return true;
    }

    public boolean canArrange(int[] arr, int k) {
       final int[] f = new int[k];
        Arrays.stream(arr).forEach(x -> f[x%k < 0 ? x%k+k : x%k]++);
        if (f[0]%2 != 0) return false;
        for (int i=1; i<=k/2; i++)
            if (f[i] != f[k-i]) return false;

        return true;
    }
}
