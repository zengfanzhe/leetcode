package com.coding.dp;

import java.util.HashSet;
import java.util.Set;

public class Q1025_divisorGame {
    public static void main(String[] args) {
        Q1025_divisorGame q1025 = new Q1025_divisorGame();
        System.out.println(q1025.divisorGame(2));
        System.out.println(q1025.divisorGame(3));
        System.out.println(q1025.divisorGame(4));
        System.out.println(q1025.divisorGame(5));
    }

    //approach 1: dp
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        for (int i=2; i<=N; i++){
            for(int j=1; j<i; j++){
                if(i % j == 0 && !dp[i - j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}
