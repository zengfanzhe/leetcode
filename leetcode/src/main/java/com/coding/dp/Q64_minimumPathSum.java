package com.coding.dp;

public class Q64_minimumPathSum {
    public static void main(String[] args) {
        Q64_minimumPathSum q64 = new Q64_minimumPathSum();
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        int[][] grid1 = new int[][]{
                {1}

        };
        System.out.println(q64.minPathSum(grid));
    }

    //approach1: backtracking, but Time Limit Exceeded
    public int minPathSum2(int[][] grid) {
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        helper(grid, 0, 0, 0, res);
        return res[0];
    }

    private void helper(int[][] grid, int x, int y, int temp, int[] res) {
        if(x == grid.length-1 && y == grid[0].length-1){
            temp += grid[x][y];
            res[0] = Math.min(res[0], temp);
            return;
        }

        if(x >= grid.length || y>=grid[0].length)
            return;

        temp += grid[x][y];
        if(temp >= res[0])
            return;
        helper(grid, x, y+1, temp, res);//to right
        helper(grid, x+1, y, temp, res);//to bottom
    }


    //approach2: dp
    public int minPathSum(int[][] grid) {
        int x = grid.length-1;
        int y = grid[0].length-1;
        int right,bottom;
        while(x >=0 && y>=0){
            if(x == grid.length-1 && y == grid[0].length-1){
                grid[x][y] = grid[grid.length-1][grid[0].length-1];
            }else{
                grid[x][y] += Math.min(grid[x+1][y], grid[x][y+1]);
            }

            for(int i=x-1; i>=0; i--){
                right = (y+1>=grid[0].length)?Integer.MAX_VALUE:grid[i][y+1];
                bottom = grid[i+1][y];
                grid[i][y] += Math.min(right, bottom);
            }
            for(int j=y-1; j>=0; j--){
                right = grid[x][j+1];
                bottom = (x+1 >= grid.length)?Integer.MAX_VALUE:grid[x+1][j];
                grid[x][j] += Math.min(right, bottom);
            }
            x--;  y--;
        }
        return grid[0][0];
    }
}
