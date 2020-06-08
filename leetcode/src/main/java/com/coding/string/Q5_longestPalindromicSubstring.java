package com.coding.string;


public class Q5_longestPalindromicSubstring {
    public static void main(String[] args) {
        Q5_longestPalindromicSubstring q5 = new Q5_longestPalindromicSubstring();
        System.out.println(q5.longestPalindrome("babad"));
        System.out.println(q5.longestPalindrome(""));
        System.out.println(q5.longestPalindrome("b"));
        System.out.println(q5.longestPalindrome("cbbd"));
        System.out.println(q5.longestPalindrome("aaaaaaa"));
    }
    public String longestPalindrome(String s) {
        if(s == null)
            return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxlen=-1, len=0, low=0, high=0;
        while(len < s.length()){
            for(int i=0; i+len<s.length(); i++){
                //[i,i+len]
                int j = i+len;
                if(len <= 1)dp[i][j] = s.charAt(i) == s.charAt(j);
                else dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];

                if(dp[i][i+len] && len > maxlen){
                    maxlen = len;
                    low = i;
                    high = j+1;
                }
            }
            len++;
        }
        return s.substring(low, high);
    }
}
