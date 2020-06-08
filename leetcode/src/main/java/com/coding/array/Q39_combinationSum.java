package com.coding.array;

import java.util.LinkedList;
import java.util.List;

public class Q39_combinationSum {

    public static void main(String[] args) {
        Q39_combinationSum q39 = new Q39_combinationSum();
        List<List<Integer>> res;
        res = q39.combinationSum(new int[]{2,3,6,7}, 7);
        printResult(res);

        res = q39.combinationSum(new int[]{2}, 2);
        printResult(res);

        res = q39.combinationSum(new int[]{2,3,6,7}, 14);
        printResult(res);

        res = q39.combinationSum(new int[]{2,3,6,7}, 0);
        printResult(res);
    }

    private static void printResult(List<List<Integer>> res) {
            for(int i=0; i<res.size(); i++){
                for(int j=0; j<res.get(i).size(); j++)
                    System.out.print(res.get(i).get(j)+" ");
                System.out.println();
            }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(candidates == null || candidates.length == 0)
            return res;
        heler(candidates, 0, target, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private void heler(int[] candidates, int index, int target,
                       int sum, LinkedList<Integer> list, List<List<Integer>> res) {
        if(sum == target){
            res.add(new LinkedList<Integer>(list));
            return ;
        }else if(sum > target){
            return ;
        }

        for(int i=index; i<candidates.length; i++){
            sum+=candidates[i];
            list.add(candidates[i]);
            heler(candidates, i, target, sum, list, res);
            list.removeLast();
            sum-=candidates[i];
        }
    }

}
