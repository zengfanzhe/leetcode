package com.coding.graph;

public class Q997_findtheTownJudge {
    public static void main(String[] args) {
        Q997_findtheTownJudge q997 = new Q997_findtheTownJudge();
        int result = 0;

        result = q997.findJudge(1, new int[][]{});
        System.out.println(result);

        //[[1,3],[1,4],[2,3],[2,4],[4,3]]
        result = q997.findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}});
        System.out.println(result);

        result = q997.findJudge(3, new int[][]{{1,2},{2,3}});
        System.out.println(result);
    }

    public int findJudge(int N, int[][] trust) {
       int[] trustCount = new int[N+1];
       for(int i=0; i<trust.length; i++){
           trustCount[trust[i][1]]++;
           trustCount[trust[i][0]]--;
       }

       for(int i=1; i<=N; i++){
           if(trustCount[i] == N-1)
               return i;
       }
       return -1;
    }
}
