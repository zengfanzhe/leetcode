package com.coding.dp;

public class Q1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        Q1143_LongestCommonSubsequence q1143 = new Q1143_LongestCommonSubsequence();
        System.out.println(q1143.longestCommonSubsequence("abcdea","ace"));
        System.out.println(q1143.longestCommonSubsequence("abc","abc"));
        System.out.println(q1143.longestCommonSubsequence("abc","def"));
        System.out.println(q1143.longestCommonSubsequence("bl","yby"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=text1.length()-1; i>=0; i--){
            for (int j=text2.length()-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]+1;
                }else{
                    dp[i][j] = max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }

    private int max(int a, int b){
        return a > b ? a : b;
    }
}
