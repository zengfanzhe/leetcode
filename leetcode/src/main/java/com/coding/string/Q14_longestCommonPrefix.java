package com.coding.string;

public class Q14_longestCommonPrefix {
    public static void main(String[] args) {
        Q14_longestCommonPrefix q14 = new Q14_longestCommonPrefix();
        String[] strs;

        strs = new String[]{"flower","flow","flight"};
        System.out.println(q14.longestCommonPrefix(strs));

        strs = new String[]{"dog","racecar","car"};
        System.out.println(q14.longestCommonPrefix(strs));

        strs = new String[]{"","flow","flight"};
        System.out.println(q14.longestCommonPrefix(strs));

        strs = new String[]{"flower"};
        System.out.println(q14.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String res = strs[0];
        for(int i=1; i< strs.length; i++){
            String temp = strs[i];
            int minLen = temp.length() > res.length() ? res.length() : temp.length();
            int count = 0;
            for (int j=0; j<minLen; j++){
                if(res.charAt(j) != temp.charAt(j))
                    break;
                count++;
            }
            res = res.substring(0, count);
        }
        return res;
    }
}
