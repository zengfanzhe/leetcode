package com.coding.breadthFirstSearch;

public class Q1306_jumpGameIII {

    public static void main(String[] args) {
        Q1306_jumpGameIII q1306_jumpGameIII = new Q1306_jumpGameIII();
        System.out.println(q1306_jumpGameIII.canReach(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println(q1306_jumpGameIII.canReach(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println(q1306_jumpGameIII.canReach(new int[]{3,0,2,1,2}, 2));
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        for (int i=0; i<arr.length; i++){
            visited[i] = false;
        }
        return canReach(arr, start, visited);
    }

    private boolean canReach(int[] arr, int start, boolean[] visited) {
        if (start >= arr.length || start < 0 || visited[start])
            return false;

        if(arr[start] == 0)
            return true;

        visited[start] = true;
        boolean a = canReach(arr, start + arr[start], visited);
        boolean b = canReach(arr, start - arr[start], visited);

        return a || b;
    }
}
