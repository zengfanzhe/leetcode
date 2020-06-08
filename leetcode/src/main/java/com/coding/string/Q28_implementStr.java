package com.coding.string;

public class Q28_implementStr {
    public static void main(String[] args) {
        Q28_implementStr q28 = new Q28_implementStr();
        System.out.println(q28.strStr("hello", "ll"));
        System.out.println(q28.strStr("aaaaa", "bba"));
        System.out.println(q28.strStr("iiiiio", "io"));
        System.out.println(q28.strStr("q", "q"));
        System.out.println(q28.strStr("q", ""));
        System.out.println(q28.strStr("", ""));
        System.out.println(q28.strStr("", "q"));

    }

    public int strStr(String haystack, String needle) {
        if("".equals(needle))
            return 0;

        int res = -1;
        int len = needle.length();
        for(int i=0; i<haystack.length(); i++){
            if(i+len>haystack.length())
                break;

            int index = i,j;
            for(j=0;j<len; j++, index++){
                if(haystack.charAt(index) != needle.charAt(j))
                    break;
            }
            if(j == len){
                res = i;
                break;
            }
        }
        return res;
    }
}
