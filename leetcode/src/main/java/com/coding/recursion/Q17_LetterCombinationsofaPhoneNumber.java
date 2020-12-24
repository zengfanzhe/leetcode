package com.coding.recursion;

import java.util.*;
import java.util.stream.Collectors;

public class Q17_LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        Q17_LetterCombinationsofaPhoneNumber q17 = new Q17_LetterCombinationsofaPhoneNumber();
        List<String> list = q17.letterCombinations("3463877");
        String res = list.stream().collect(Collectors.joining(","));
        System.out.println(res);
        // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        //ad,ae,af,bd,be,bf,cd,ce,cf
    }

    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        return helper(digits, map);
    }

    private List<String> helper(String digits, Map<String, String> map) {
        if ("".equals(digits)){
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        List<String> subList = helper(digits.substring(1), map);
        String str = map.get(digits.substring(0,1));
        for (int i=0; i<str.length(); i++){
            String sub = str.substring(i, i+1);
            if (subList.isEmpty()){
                res.add(sub);
            }else{
                for (String s: subList){
                    res.add(sub + s);
                }
            }
        }
        return res;
    }
}
