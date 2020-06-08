package com.coding.string;

public class Q395_longestSubstringwithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        Q395_longestSubstringwithAtLeastKRepeatingCharacters q395 = new Q395_longestSubstringwithAtLeastKRepeatingCharacters();
        System.out.println(q395.longestSubstring("aaabb", 3));
        System.out.println(q395.longestSubstring("ababbc", 2));
        System.out.println(q395.longestSubstring("a", 1));
        System.out.println(q395.longestSubstring("abcde", 2));
    }

    public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        return helper(arr, 0, s.length(), k);
    }

    //[start, end)
    private int helper(char[] arr, int start, int end, int k) {
        if(k > (end - start))
            return 0;

        int[] count = new int[26];
        for(int i=start; i<end; i++)
            count[arr[i] - 'a']++;

        for(int i=start; i<end; i++){
            if(count[arr[i] - 'a'] < k && count[arr[i] - 'a'] > 0){
                int left = helper(arr, start, i, k);
                int right = helper(arr, i+1, end, k);
                return Math.max(left, right);
            }
        }

        return end-start;
    }
}
