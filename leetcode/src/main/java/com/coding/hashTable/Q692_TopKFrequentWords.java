package com.coding.hashTable;

import java.util.*;
import java.util.stream.Collectors;

public class Q692_TopKFrequentWords {

    public static void main(String[] args) {
        Q692_TopKFrequentWords q692 = new Q692_TopKFrequentWords();
        q692.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2)
                .stream()
                .forEach(x -> System.out.print(x + ","));

        System.out.println();

        q692.topKFrequent2(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4)
                .stream()
                .forEach(x -> System.out.print(x + ","));
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.stream(words).forEach(x -> map.put(x, map.getOrDefault(x, 0)+1));
        return map.keySet()
                .stream()
                .sorted((x, y) -> map.get(x).equals(map.get(y)) ? x.compareTo(y) : map.get(y) - map.get(x))
                .collect(Collectors.toList())
                .subList(0,k);
    }


    public List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        ArrayList<String> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr, (x, y) -> map.get(x).equals(map.get(y)) ? x.compareTo(y) : map.get(y) - map.get(x));
        return arr.subList(0, k);
    }
}
