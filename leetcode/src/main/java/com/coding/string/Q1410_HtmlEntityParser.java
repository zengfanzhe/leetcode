package com.coding.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q1410_HtmlEntityParser {

    public static void main(String[] args) {
        test("&amp; is an HTML entity but &ambassador; is not.",
                "& is an HTML entity but &ambassador; is not.");

        test("and I quote: &quot;...&quot;",
                "and I quote: \"...\"");

        test("x &gt; y &amp;&amp; x &lt; y is always false",
                "x > y && x < y is always false");

        test("leetcode.com&frasl;problemset&frasl;all",
                "leetcode.com/problemset/all");

        test("&apos;A&apos;",
                "'A'");

        test("Stay home! Practice on Leetcode :)",
                "Stay home! Practice on Leetcode :)");

        "asd".replace("", "");
    }

    public static void test(String input, String expected){
        Q1410_HtmlEntityParser q1410 = new Q1410_HtmlEntityParser();
        String result = q1410.entityParser(input);
        System.out.println("input str is : " + input);
       // System.out.println("expected str is : " + expected);
        System.out.println("result str is : " + result);
        //System.out.println("isEqual? : " + expected.equals(result));
        if(!expected.equals(result)){
            throw new RuntimeException("false");
        }
        System.out.println("-----------------------------");
    }

    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        init(map);
        StringBuffer result = new StringBuffer();
        int end = 0;
        int i = -1;
        char[] arr = text.toCharArray();
        for (int k = 0; k < arr.length; k++) {
            if(arr[k] == '&'){
                i = k;
            }else if(arr[k] == ';'){
                if(i != -1){
                    String key = text.substring(i, k);
                    String value = map.get(key);
                    if(value != null){
                        result.append(text.substring(end, i)).append(value);
                        end = k + 1;
                    }
                    i = -1;
                }
            }
        }
        if(end < arr.length){
            result.append(text.substring(end, arr.length));
        }

        return result.toString();
    }

    private void init(Map<String, String> map) {
        map.put("&amp", "&");
        map.put("&quot", "\"");
        map.put("&apos", "'");
        map.put("&gt", ">");
        map.put("&frasl", "/");
        map.put("&lt", "<");
    }

}
