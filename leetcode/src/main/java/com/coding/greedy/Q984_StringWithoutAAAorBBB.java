package com.coding.greedy;

public class Q984_StringWithoutAAAorBBB {
    public static void main(String[] args) {
        Q984_StringWithoutAAAorBBB q984 = new Q984_StringWithoutAAAorBBB();
        System.out.println(q984.strWithout3a3b(4,1));
        System.out.println(-13%7);
        System.out.println(-13/7);
        System.out.println(20%7);
    }

    //approach 1
    public String strWithout3a3b(int a, int b) {
        if (a == 0){
            if (b == 0){
                return "";
            }else if (b == 1){
                return "b";
            }else {
                return "bb";
            }
        }else if (b == 0){
            if (a == 0){
                return "";
            }else if (a == 1){
                return "a";
            }else {
                return "aa";
            }
        }else if (a == b){
            return "ab" + strWithout3a3b(a-1, b-1);
        }else if (a > b){
            return "aab" + strWithout3a3b(a-2, b-1);
        }else {
            return strWithout3a3b(a-1, b-2) + "abb";
        }
    }
}
