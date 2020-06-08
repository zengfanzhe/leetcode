package com.coding.string;


public class Q1032_streamOfCharacters {

    public static void main(String[] args) {
        //case 1:
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd","f","kl"});

        test(streamChecker.query('a'), false);         // return false
        test(streamChecker.query('b'), false);          // return false
        test(streamChecker.query('c'), false);          // return false
        test(streamChecker.query('d'), true );          // return true,
        test(streamChecker.query('e'), false);          // return false
        test(streamChecker.query('f'), true);          // return true,
        test(streamChecker.query('g'), false);          // return false
        test(streamChecker.query('h'), false);          // return false
        test(streamChecker.query('i'), false);          // return false
        test(streamChecker.query('j'), false);          // return false
        test(streamChecker.query('k'), false);          // return false
        test(streamChecker.query('l'), true);          // return true,
    }

    private static void test(boolean actual, boolean excepted) {
        if (actual != excepted)
            throw new RuntimeException("error");
    }



}


class StreamChecker {
    private TrieNode root = new TrieNode();
    private StringBuffer sb = new StringBuffer();

    public StreamChecker(String[] words) {
        createTrie(words);
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i=sb.length()-1; i>=0 && node !=null; i--){
            node = node.next[sb.charAt(i) - 'a'];
            if(node != null && node.isword){
                return true;
            }
        }
        return false;
    }

    void createTrie(String[] words){
        for(String w : words){
            char[] cs = w.toCharArray();
            TrieNode node = root;
            for(int i=cs.length-1; i>=0; i--){
                if(node.next[cs[i] - 'a'] == null){
                    node.next[cs[i] - 'a'] = new TrieNode();
                }
                node = node.next[cs[i] - 'a'];
            }
            node.isword = true;
        }
    }

    class TrieNode{
        public boolean isword;
        public TrieNode[] next = new TrieNode[26];
    }
}
