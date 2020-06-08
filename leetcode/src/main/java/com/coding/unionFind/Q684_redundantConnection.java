package com.coding.unionFind;

public class Q684_redundantConnection {

    public static void main(String[] args) {
        Q684_redundantConnection q684 = new Q684_redundantConnection();
        int[][] edges;
        int[] result;

        edges = new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        result = q684.findRedundantConnection(edges);
        System.out.println("[" + result[0] + "," + result[1] + "]");

    }

    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);
        for (int[] edge : edges) {
            if(!disjointSet.union(edge[0]-1, edge[1]-1))
                return edge;
        }
        throw new IllegalArgumentException();
    }

    static class DisjointSet{
        private int[] parent;
        private byte[] rank;

        public DisjointSet(int n){
            parent = new int[n];
            rank = new byte[n];
        }

        public int find(int x){
            if(parent[x] == 0) return x;
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return false;

            if(rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else if(rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else{
                parent[rootX] = rootY;
                rank[rootY]++;
            }

            return true;
        }
    }
}
