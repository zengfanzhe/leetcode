package com.coding.backTracking;

public class Q60_permutationSequence {

    public static void main(String[] args) {
        Q60_permutationSequence q60 = new Q60_permutationSequence();
        System.out.println(q60.getPermutation(1,1));
    }

    private Integer count=0;
    private String result;
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];//default is false?
        helper(n, k, "",visited, 0);
        return this.result;
    }

    private void helper(int n, int k, String s, boolean[] visited, int depth) {
        if(depth >= n){
            this.count++;
            if(count==k)
                this.result=s;
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i]==true)
                continue;

            s+=(i+1);
            visited[i]=true;
            helper(n,k,s,visited,depth+1);
            s=s.substring(0,s.length()-1);
            visited[i]=false;
        }
    }
}
