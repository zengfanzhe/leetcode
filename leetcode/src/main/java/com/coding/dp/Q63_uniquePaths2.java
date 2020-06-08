package com.coding.dp;

public class Q63_uniquePaths2 {
    public static void main(String[] args) {
        Q63_uniquePaths2 q63 = new Q63_uniquePaths2();
        int[][] arr = new int[][]{
                {0,0,1},
                {0,0,1},
                {0,0,1}
        };
        System.out.println(q63.uniquePathsWithObstacles(arr));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[m-1][n-1] == 1){
            dp[m-1][n-1] = 0;
        }else{
            dp[m-1][n-1] = 1;
        }

        for(int i=m-2; i>=0; i--){
            if(obstacleGrid[i][n-1] == 1){
                dp[i][n-1]=0;
            }else{
                dp[i][n-1] = dp[i+1][n-1];
            }
        }
        for(int j=n-2; j>=0; j--){
            if(obstacleGrid[m-1][j] == 1){
                dp[m-1][j]=0;
            }else{
                dp[m-1][j] = dp[m-1][j+1];
            }
        }


        for(int i=m-2; i>=0; i--){
            for(int j = n-2; j>=0; j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
