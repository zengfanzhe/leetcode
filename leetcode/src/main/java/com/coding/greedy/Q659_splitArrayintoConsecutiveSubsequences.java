package com.coding.greedy;

import java.util.HashMap;
import java.util.Map;

public class Q659_splitArrayintoConsecutiveSubsequences {

    public static void main(String[] args) {
        Q659_splitArrayintoConsecutiveSubsequences q659 = new Q659_splitArrayintoConsecutiveSubsequences();
        System.out.println(q659.isPossible(new int[]{1,2,3,3,4,5}));
        System.out.println(q659.isPossible(new int[]{1,2,3,3,4,4,5,5}));
        System.out.println(q659.isPossible(new int[]{1,2,3,4,4,5}));
    }

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        for (int i : nums)
            counter.put(i, getValue(counter, i) + 1);

        for (int num : nums){
            if(counter.get(num) == 0)
                continue;

            counter.put(num, counter.get(num)-1);

            if(getValue(end, num-1) > 0){
                end.put(num-1, getValue(end, num-1)-1);
                end.put(num, getValue(end, num)+1);
            }else if(getValue(counter, num+1) > 0 && getValue(counter, num+2) > 0){
                counter.put(num+1, getValue(counter,num+1)-1);
                counter.put(num+2, getValue(counter,num+2)-1);
                end.put(num+2, getValue(end,num+2)+1);
            }else {
                return false;
            }
        }
        return true;
    }

    private int getValue(Map<Integer, Integer> counter, int i) {
        return counter.containsKey(i) ? counter.get(i) : 0;
    }


}
