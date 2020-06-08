package com.coding.dp;

public class Q338_countingBits {
    public static void main(String[] args) {
        Q338_countingBits q338 = new Q338_countingBits();
        int[] result;
        result = q338.countBits(2);
        printResult(result);

        result = q338.countBits(5);
        printResult(result);

        result = q338.countBits(0);
        printResult(result);

        result = q338.countBits(1);
        printResult(result);
    }

    private static void printResult(int[] result) {
        for(Integer i : result)
            System.out.print(i + ",");
        System.out.println();
    }

    public int[] countBits(int num) {
        //dp[i] = dp[i - 2^k] + 1; where 2^(k+1) > i >= 2^k
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for(int i=1; i<=num; i++){
            int temp = 1;
            while(temp <= i)
                temp=temp<<1;
            temp = temp>>1;
            dp[i] = dp[i-temp] + 1;
        }
        return dp;
    }
}
