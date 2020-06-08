package com.coding.array;

public class Q907_sumOfSubarrayMinimums {
    public static void main(String[] args) {
        Q907_sumOfSubarrayMinimums q907 = new Q907_sumOfSubarrayMinimums();
        System.out.println(q907.sumSubarrayMins(new int[]{3,1,2,4}));
        //TODO:

    }

    public int sumSubarrayMins2(int[] A) {
        int result = 0;
        int NUM = (int)Math.pow(10,9) + 7;
        int[][] dp = new int[A.length][A.length];
       for(int i=A.length-1; i>=0; i--){
           for(int j=i; j<A.length; j++){
               if(j == i){
                   dp[i][j] = A[i];
               }else{
                   dp[i][j] = Math.min(dp[i][j-1], dp[j][j]);
               }
               dp[i][j]=dp[i][j]%NUM;
               result=(result + dp[i][j])%NUM;
           }
       }
       return result;
    }

    public int sumSubarrayMins(int[] A) {
        int result = 0;
        int NUM = (int)Math.pow(10,9) + 7;
        int[] dp = new int[A.length];
        for(int i=A.length-1; i>=0; i--){
            for(int j=i; j<A.length; j++){
                if(i == j){
                    dp[j] = A[i];
                }else {
                    dp[j] = Math.min(A[i], dp[j]);
                }
                dp[j]=dp[j]%NUM;
                result=(result + dp[j])%NUM;
            }
        }
        return result;
    }
}
