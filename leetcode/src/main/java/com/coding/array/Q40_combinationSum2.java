package com.coding.array;

import java.util.*;

public class Q40_combinationSum2 {

    public static void main(String[] args) {
        Q40_combinationSum2 q40 = new Q40_combinationSum2();
        List<List<Integer>> res;

        res = q40.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        printResult(res);

        System.out.println("*************");

        res = q40.combinationSum2(new int[]{2,5,2,1,2}, 5);
        printResult(res);
    }

    private static void printResult(List<List<Integer>> res) {
        for(int i=0; i<res.size(); i++){
            for(int j=0; j<res.get(i).size(); j++)
                System.out.print(res.get(i).get(j)+" ");
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        LinkedList<Integer> tempList = new LinkedList<>();
        heler(candidates, 0, target, 0, tempList , res);
        return res;
    }

    private void heler(int[] candidates, int index, int target,
                       int sum, LinkedList<Integer> list, LinkedList<List<Integer>> res) {
        if (sum == target) {
            res.add(new LinkedList<Integer>(list));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(i>index && candidates[i] == candidates[i-1])continue;
            sum += candidates[i];
            list.add(candidates[i]);
            heler(candidates, i+1, target, sum, list, res);
            list.removeLast();
            sum -= candidates[i];
        }
    }

}