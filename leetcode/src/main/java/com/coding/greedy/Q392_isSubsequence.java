package com.coding.greedy;

public class Q392_isSubsequence {
    public static void main(String[] args) {
        Q392_isSubsequence q392 = new Q392_isSubsequence();
        System.out.println(q392.isSubsequence("abc", "ahbgdc"));
        System.out.println(q392.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int ti=0;
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        for(Character c : sarr){
            ti = verify(ti, tarr, c);
            if(ti == -1)
                return false;
        }
        return true;
    }

    private int verify(int ti, char[] tarr, Character c) {
        for(int i=ti; i<tarr.length; i++){
            if(tarr[i] == c)
                return i+1;
        }
        return -1;
    }
}
