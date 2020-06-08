package com.coding.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q720_longestWordInDictionary {

    public static void main(String[] args) {
        Q720_longestWordInDictionary q720 = new Q720_longestWordInDictionary();
        String[] words;
        String res;

        words = new String[]{"w","wo","wor","worl", "world"};
        res = q720.longestWord(words);
        System.out.println(res);

        words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        res = q720.longestWord(words);
        System.out.println(res);
    }

    //Approach1: Brute Force
    public String longestWord2(String[] words) {
        Set<String> set = new HashSet<>();
        for(String w : words) set.add(w);

        String ans = "";
        for(String word : words){
            if(word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0){
                boolean flag = true;
                for(int i=1; i<word.length(); i++){
                    if(!set.contains(word.substring(0,i))){
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    ans = word;
            }
        }
        return ans;
    }


    //Approach2: trie + dfs
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for(String word : words){
            trie.insert(word, ++index);
        }
        trie.words = words;
        return trie.getResult();
    }

    class Node{
        char c;
        HashMap<Character, Node> children = new HashMap<>();
        int end;

        public Node(char c){
            this.c = c;
        }
    }

    class Trie{
        Node root;
        String[] words;

        public Trie(){
            root = new Node('0');
        }

        public void insert(String word, int index){
            Node cur = root;
            for(Character c : word.toCharArray()){
                if(!cur.children.containsKey(c)) cur.children.put(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }

        private String result = "";
        private void dfs(Node node){
            if(node.c != '0' && node.end == 0)
                return;
            if(node.c != '0'){
                 String temp = words[node.end - 1];
                 if(result.length() < temp.length() ||
                    result.length() == temp.length() && temp.compareTo(result) < 0)
                 result = temp;
            }

            for(Node n : node.children.values())
                dfs(n);

        }

        public String getResult(){
            this.dfs(root);
            return result;
        }
    }

}
