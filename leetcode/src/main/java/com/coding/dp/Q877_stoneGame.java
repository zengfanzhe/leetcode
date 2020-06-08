package com.coding.dp;

import java.util.HashMap;

public class Q877_stoneGame {
    public static void main(String[] args) {
        Q877_stoneGame q877 = new Q877_stoneGame();
        System.out.println(q877.stoneGame(new int[]{7,8,8,10}));
        System.out.println(q877.stoneGame(new int[]{5,3,4,5}));
        System.out.println(q877.stoneGame(new int[]{1,2}));
        System.out.println(q877.stoneGame(new int[]{1}));
        System.out.println(q877.stoneGame(new int[]{1, 20, 3}));
    }

    public boolean stoneGame(int[] piles) {
        HashMap<String, Boolean> memo = new HashMap<>();
        return helper(piles, 1, 0, 0, piles.length, memo);
    }

    //inculde begin, but exculde end
    private boolean helper(int[] piles, int flag, int sum, int begin, int end,
                           HashMap<String, Boolean> memo) {
        String s0 = flag + "," + sum + "," + begin + "," + end;
        boolean b1, b2, result;

        if(end - begin == 1){
            result = (sum + flag * piles[begin]) > 0;
            memo.put(s0, result);
            return result;
        }

        String s1 = -flag + "," + (sum +flag * piles[begin]) + "," + (begin + 1) + "," + end;
        String s2 = -flag + "," + (sum + flag * piles[end-1]) + "," + begin + "," + (end - 1);

        if(memo.containsKey(s1)){
            b1 = memo.get(s1);
        }else {
            b1 = helper(piles, -flag, sum + flag * piles[begin], begin + 1, end, memo);
            memo.put(s1, b1);
        }

        if(memo.containsKey(s2)){
            b2 = memo.get(s2);
        }else {
            b2 = helper(piles, -flag, sum + flag * piles[end-1], begin, end - 1, memo);
            memo.put(s2, b2);
        }

        if (flag > 0){
            result = b1 || b2;
        }else {
            result = b1 && b2;
        }

        memo.put(s0, result);
        return result;
    }
}
