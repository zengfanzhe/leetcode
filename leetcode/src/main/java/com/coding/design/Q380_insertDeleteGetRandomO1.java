package com.coding.design;

import java.util.*;

import static java.util.Collections.swap;

public class Q380_insertDeleteGetRandomO1 {

    public static void main(String[] args) {
        RandomizedSet rset = new Q380_insertDeleteGetRandomO1().new RandomizedSet();
        rset.insert(0);
        rset.remove(0);
        rset.insert(-1);
        rset.remove(0);
        System.out.println(rset.getRandom());
        System.out.println(rset.getRandom());
    }

    class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val))return false;

            this.list.add(val);
            map.put(val, this.list.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val))return false;

            int index = map.get(val);
            swap(list, index, list.size()-1);
            map.put(list.get(index), index);
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            if (list.size() == 0)
                throw new RuntimeException("list's size is zero.");

            int index = (int)(Math.random() * list.size());
            return list.get(index);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
