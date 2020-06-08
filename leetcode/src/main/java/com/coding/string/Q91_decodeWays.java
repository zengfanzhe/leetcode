package com.coding.string;

public class Q91_decodeWays {
    public static void main(String[] args) {
        Q91_decodeWays q91 = new Q91_decodeWays();
        System.out.println(q91.numDecodings("226"));
        System.out.println(q91.numDecodings(""));
        System.out.println(q91.numDecodings("302"));
        System.out.println(q91.numDecodings("3020"));
    }

    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0')
            return 0;

        if(s.length() == 1)
            return 1;

        return numDecodings(s.substring(1)) +
                (Integer.valueOf(s.substring(0,2)) > 26 ? 0 :
                        (s.length()>2 ? numDecodings(s.substring(2)) : 1));
    }



}
