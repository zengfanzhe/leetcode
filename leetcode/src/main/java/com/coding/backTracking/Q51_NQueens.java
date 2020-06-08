package com.coding.backTracking;


import java.util.LinkedList;
import java.util.List;

/**
 * uncompleted
 */
public class Q51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        boolean[][] map = new boolean[n][n];
        helper(n, res, map, 0, new LinkedList<String>());
        return res;
    }

    private void helper(int n, List<List<String>> res, boolean[][] map, int depth, LinkedList<String> temp) {
        if(depth >= n){
            if(verifyMap(map, n)){
                res.add(new LinkedList<String>(temp));
            }
            return;
        }
        for(int i=0; i<n; i++){
            map[depth][i] = true;
            addToTemp(temp, n, i);
            helper(n, res, map, depth+1, temp);
            temp.removeLast();
            map[depth][i] = false;
        }
    }

    private boolean verifyMap(boolean[][] map, int n) {
        int count;
        for(int j=0; j<n; j++){
            count=0;
            for(int i=0; i<n; i++){
                if(map[i][j])
                    count++;
            }
            if(count>1)
                return  false;
        }

        //TODO:

        return true;
    }

    private void addToTemp(List<String> temp, int n, int k){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<n; i++){
            if(i==k){
                builder.append('Q');
            }else{
                builder.append('.');
            }
        }
        temp.add(builder.toString());
    }
}
