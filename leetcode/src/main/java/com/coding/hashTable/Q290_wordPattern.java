package com.coding.hashTable;

import java.util.HashMap;

public class Q290_wordPattern {
    public static void main(String[] args) {
        Q290_wordPattern q290 = new Q290_wordPattern();
        System.out.println(q290.wordPattern("abba","dog cat cat dog"));
        System.out.println(q290.wordPattern("abba","dog cat cat fish"));
        System.out.println(q290.wordPattern("abba","dog dog dog dog"));

    }
    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] s = str.split(" ");

        if(p.length != s.length)
            return  false;

        HashMap<Character, String> map = new HashMap<>();
        for (int i=0; i<p.length; i++){
            if(!map.containsKey(p[i])){
                if(map.containsValue(s[i]))
                    return false;
                map.put(p[i], s[i]);
            }else{
                if(!map.get(p[i]).equals(s[i]))
                    return false;
            }
        }
        return true;
    }
}
