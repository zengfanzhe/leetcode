package com.coding.backTracking;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q542_maxtrix01 {
    public static void main(String[] args) {
        Q542_maxtrix01 q542 = new Q542_maxtrix01();
        printArr(q542.updateMatrix(new int[][]{
                {1,0},
                {0,1},
                {1,1}
        }));
    }

    private static void printArr(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
    }

    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][];
        for(int i=0; i<res.length; i++){
            res[i] = new int[matrix[i].length];
            for (int j=0; j<res[i].length; j++){
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Map.Entry<Integer,Integer>> queue = new LinkedList();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0) {
                    queue.add(new java.util.AbstractMap.SimpleImmutableEntry(i, j));
                    res[i][j] = 0;
                }
            }
        }
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            Map.Entry<Integer,Integer> entry = queue.poll();
            int x = entry.getKey();
            int y = entry.getValue();
            for(int i=0; i<4; i++){
                int new_x = x+dir[i][0];
                int new_y = y+dir[i][1];
                if(new_x >=0 && new_x < res.length && new_y >=0 && new_y < res[new_x].length
                        && res[new_x][new_y] == Integer.MAX_VALUE){
                    res[new_x][new_y] = res[x][y]+1;
                    queue.add(new java.util.AbstractMap.SimpleImmutableEntry(new_x, new_y));
                }
            }
        }
        return res;
    }


    /**
     * approach2: use DP
     * @param matrix
     * @return
     */
    public int[][] updateMatrix2(int[][] matrix) {
        //TODO:

        return null;
    }
}
