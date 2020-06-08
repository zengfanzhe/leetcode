package com.coding.dp;

public class Q121_bestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Q121_bestTimeToBuyAndSellStock q121 = new Q121_bestTimeToBuyAndSellStock();
        System.out.println(q121.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(q121.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(q121.maxProfit(new int[]{}));
    }

    //approach 1:
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int[] memo = new int[prices.length];
        memo[memo.length-1] = 0;
        for (int i=prices.length-2; i>=0; i--)
            memo[i] = Math.max(memo[i+1], prices[i+1]);
        int max = 0;
        for (int i=0; i<prices.length; i++){
            int temp = memo[i] - prices[i];
            if(max < temp)
                max = temp;
        }
        return max;
    }

    //approach 2:
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++){
            if(minPrice > prices[i])
                minPrice = prices[i];
            else if (maxProfit < prices[i] - minPrice) {
                    maxProfit = prices[i] - minPrice;
            }

        }
        return maxProfit;
    }
}
