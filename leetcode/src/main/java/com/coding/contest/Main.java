package com.coding.contest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int res = func(1024 - N);
        System.out.println(res);
    }

    private static int func(int sum) {
        int[] mem = new int[sum+1];
        for(int i=0; i< sum+1; i++){
            mem[i] = Integer.MAX_VALUE;
        }
        return helper(sum, mem);
    }

    private static int helper(int sum, int[] mem) {
        if(sum<=0)
            return 0;
        int n64 = Integer.MAX_VALUE;
        int n16 = Integer.MAX_VALUE;
        int n4 = Integer.MAX_VALUE;
        int n1 = Integer.MAX_VALUE;

        if(sum >= 64){
            if(mem[sum - 64] != Integer.MAX_VALUE){
                n64 = mem[sum-64] + 1;
            }else{
                n64 = helper(sum-64, mem)+1;
            }
        }

        if(sum >= 16){
            if(mem[sum - 16] != Integer.MAX_VALUE){
                n16 = mem[sum-16] + 1;
            }else{
                n16 = helper(sum-16, mem)+1;
            }
        }
        if(sum>=4){
            if(mem[sum - 4] != Integer.MAX_VALUE){
                n4 = mem[sum-4] + 1;
            }else{
                n4 = helper(sum-4, mem)+1;
            }
        }
        if(sum>=1){
            if(mem[sum - 1] != Integer.MAX_VALUE){
                n1 = mem[sum-1] + 1;
            }else{
                n1 = helper(sum-1, mem)+1;
            }
        }

        int res = min(n64, n16, n4, n1);
        mem[sum] = res;
        return mem[sum];
    }

    private static int min(int n64, int n16, int n4, int n1) {
        int min=Integer.MAX_VALUE;
        if(n64 < min)
            min = n64;
        if(n16 < min)
            min = n16;
        if(n4 < min)
            min = n4;
        if(n1 < min)
            min = n1;
        return min;
    }


}