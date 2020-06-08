package com.coding.string;

public class Q859_buddyStrings {
    public static void main(String[] args) {
        Q859_buddyStrings q859 = new Q859_buddyStrings();
        System.out.println(q859.buddyStrings("ab", "ba"));
        System.out.println(q859.buddyStrings("ab", "ab"));
        System.out.println(q859.buddyStrings("aa", "aa"));
        System.out.println(q859.buddyStrings("", "ba"));
    }

    public boolean buddyStrings(String A, String B) {
       if(A.length() != B.length())
           return false;
        char[] c = A.toCharArray();
        if(A.equals(B)){
           int[] count = new int[26];
           for(int i=0; i<c.length; i++){
               count[c[i] - 'a']++;
           }
           for(int i=0; i<26; i++){
               if(count[i] > 1)
                   return true;
           }
           return false;
       }else{
           int first = -1;
           int second = -1;
           for(int i=0; i<A.length(); i++){
               if(A.charAt(i) != B.charAt(i)){
                   if(first == -1){
                       first = i;
                   }else if(second == -1){
                       second = i;
                   }else{
                       return false;
                   }
               }
           }
           return (second != -1)&&(A.charAt(first) == B.charAt(second))
                   &&(A.charAt(second) == B.charAt(first));
       }
    }

}
