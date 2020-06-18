package com.coding.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q1192_criticalConnectionsInANetwork {
    public static void main(String[] args) {
        Q1192_criticalConnectionsInANetwork q1192 = new Q1192_criticalConnectionsInANetwork();
       //case 1
        PrintList(q1192.criticalConnections(1, new LinkedList<>()));
        //case 2
        List<List<Integer>> list = new LinkedList<>();
        list.add(Arrays.asList(0,1));
        PrintList(q1192.criticalConnections(2, list));

        //case 3
        List<List<Integer>> list2 = new LinkedList<>();
        list2.add(Arrays.asList(0,1));
        list2.add(Arrays.asList(1,2));
        list2.add(Arrays.asList(2,0));
        list2.add(Arrays.asList(1,3));
        PrintList(q1192.criticalConnections(4, list2));


        //case 4
        List<List<Integer>> list4 = new LinkedList<>();
        list4.add(Arrays.asList(0,1));
        list4.add(Arrays.asList(1,2));
        list4.add(Arrays.asList(2,0));
        list4.add(Arrays.asList(1,3));
        list4.add(Arrays.asList(2,3));
        PrintList(q1192.criticalConnections(4, list4));
    }



    private static void PrintList(List<List<Integer>> criticalConnections) {
        System.out.println(criticalConnections);
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] graph = createGraph(n, connections);
        boolean[] visited = new boolean[n];
        int[] time = new int[n];
        int[] stemp = new int[1];
        helper(graph, -1, 0, time, stemp, visited, result);

        return result;
    }

    private void helper(List<Integer>[] graph, int par, int cur, int[] time,
                        int[] stemp, boolean[] visited, List<List<Integer>> result) {
        if(graph.length == 1){
            return;
        }
        int temp = stemp[0]++;
        time[cur] = temp;
        visited[cur] = true;
        for (Integer child : graph[cur]){
            if(child == par){
                continue;
            }

            if(!visited[child]){
                helper(graph, cur, child, time, stemp, visited, result);
            }

            time[cur] = Math.min(time[cur], time[child]);

            if(temp < time[child]){
                result.add(Arrays.asList(cur, child));
            }

        }
    }

    private List<Integer>[] createGraph(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> list : connections){
            graph[list.get(0)].add(list.get(1));
            graph[list.get(1)].add(list.get(0));
        }

        return graph;
    }


}
