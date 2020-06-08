package com.coding.dp;

public class Q62_uniquePaths {
    public static void main(String[] args) {
        Q62_uniquePaths q62 = new Q62_uniquePaths();
        System.out.println(q62.uniquePaths(3,2));
        System.out.println(q62.uniquePaths(7,3));
    }

    public int uniquePaths2(int m, int n) {
        int[][] mem = new int[m][n];
        return helper(m, n, 0, 0, mem);
    }

    private int helper(int m, int n, int x, int y, int[][] mem) {
        if(x==m-1 && y==n-1)
            return 1;

        int right=0,bottom=0;

        if(y+1<n){
            if(mem[x][y+1] != 0){
                right = mem[x][y+1];
            }else{
                right = helper(m,n,x,y+1, mem);
            }
        }
        if(x+1<m){
            if(mem[x+1][y] != 0){
                bottom = mem[x+1][y];
            }else{
                bottom = helper(m, n, x+1, y, mem);
            }
        }

        mem[x][y] = right + bottom;
        return  right + bottom;
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=m-1; i>=0; i--)
            dp[i][n-1]=1;
        for(int j=n-1; j>=0; j--)
            dp[m-1][j]=1;

        for(int i=m-2; i>=0; i--){
            for(int j = n-2; j>=0; j--){
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}
