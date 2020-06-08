package com.coding.graph;

import java.util.Stack;

public class Q785_IsGraphBipartite {

    public static void main(String[] args) {
        Q785_IsGraphBipartite q785 = new Q785_IsGraphBipartite();
        int[][] graph;
        graph = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        System.out.println(q785.isBipartite(graph));

        graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(q785.isBipartite(graph));

        graph = new int[][]{{1},{0,3},{3},{1,2}};
        System.out.println(q785.isBipartite(graph));

        graph = new int[][]{{},{2},{1,3},{2}};
        System.out.println(q785.isBipartite(graph));

    }


    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        boolean[] isVisited = new boolean[len];
        int[] nodeColor = new int[len];
        for(int i=0; i<graph.length; i++){
            if(!isVisited[i]){
                if(!helper(nodeColor, isVisited, graph, i))
                    return false;
            }
        }
        return true;
    }

    private boolean helper(int[] nodeColor, boolean[] isVisited, int[][] graph, int n){
        final int RED = 1;
        final int BLACK = 2;
        final int NONE = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        nodeColor[n] = RED;
        while(!stack.empty()){
            int node = stack.pop();
            isVisited[node] = true;
            int color = nodeColor[node] == RED ? BLACK : RED;
            for(int i=0; i<graph[node].length; i++){
                if(nodeColor[graph[node][i]] == NONE){
                    nodeColor[graph[node][i]] = color;
                }else if(nodeColor[graph[node][i]] == nodeColor[node]){
                    return false;
                }
                if(!isVisited[graph[node][i]])
                    stack.push(graph[node][i]);
            }
        }
        return true;
    }
}
