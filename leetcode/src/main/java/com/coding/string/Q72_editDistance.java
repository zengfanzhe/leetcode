package com.coding.string;

public class Q72_editDistance {

    public static void main(String[] args) {
        Q72_editDistance q72 = new Q72_editDistance();

        System.out.println(q72.minDistance("horse", "ros"));

        System.out.println(q72.minDistance("intention", "execution"));
    }


    /**
     * w1[0...i] : word1 from 0 to i
     * w2[0...j] : word2 from 0 to j
     * dp[i][j] :  min distance
     * if w1[i-1] == w2[j-1] then dp[i][j] = dp[i-1][j-1]
     * if w1[i-1] != w2[j-1]
     *      case 1: replace w1[i-1] to w2[j-1] -> dp[i][j] = dp[i-1][j-1] + 1
     *      case 2: insert w2[j-1] to w1 -> dp[i][j] = d[i][j-1] + 1
     *      case 3: delete w1[i-1] -> dp[i][j] = dp[i-1][j] + 1
     *   then dp[i][j] = min(dp[i-1][j-1] + 1, d[i][j-1] + 1, dp[i-1][j] + 1)
     *
     *  dp[0][j] = j
     *  dp[i][0] = i
     */
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[w1.length+1][w2.length+1];

        for (int j=0; j<=w2.length; j++)
            dp[0][j] = j;

        for (int i=0; i<=w1.length; i++)
            dp[i][0] = i;

        for(int i=1; i<=w1.length; i++){
            for (int j=1; j<=w2.length; j++){
                if(w1[i-1] == w2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int a = dp[i-1][j-1] + 1;
                    int b = dp[i][j-1] + 1;
                    int c = dp[i-1][j] + 1;

                    int temp = a > b ? b : a;
                    dp[i][j] = temp > c ? c : temp;
                }
            }
        }
        return dp[w1.length][w2.length];
    }
}
