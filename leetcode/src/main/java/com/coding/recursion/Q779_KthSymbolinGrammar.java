package com.coding.recursion;

public class Q779_KthSymbolinGrammar {
    public static void main(String[] args) {
        Q779_KthSymbolinGrammar q779 = new Q779_KthSymbolinGrammar();
        System.out.println(q779.kthGrammar(4,5));
    }

    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;

        if (K%2==0)
            return kthGrammar(N-1, K/2) == 0 ? 1:0;
        else
            return kthGrammar(N-1, (K+1)/2) == 0 ? 0 : 1;
    }
}
