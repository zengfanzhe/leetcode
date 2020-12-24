package com.coding.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q1048_LongestStringChain {

    public static void main(String[] args) {
        Q1048_LongestStringChain q1048 = new Q1048_LongestStringChain();
        System.out.println(q1048.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println(q1048.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->a.length()- b.length());
        int res= 0;
        Map<String, Integer> dp = new HashMap<>();
        for (String s : words){
            int submax = 0;
            for (int i=0; i<s.length(); i++){
                submax = Math.max(submax, dp.getOrDefault(s.substring(0,i)+s.substring(i+1), 0));
            }
            dp.put(s, submax + 1);
            res = Math.max(res, dp.get(s));
        }
        return res;
    }
}
