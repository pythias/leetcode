package com.duo.leetcode.challenge;

import com.duo.leetcode.Algorithm;

public class MaxProfit implements Algorithm {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        for (int price : prices) {
            if (price < buy) {
                if (sell > 0) {
                    profit += (sell - buy);
                    sell = 0;
                }
                buy = price;
            } else {
                if (price > sell) {
                    sell = price;
                } else {
                    profit += (sell - buy);
                    buy = price;
                    sell = 0;
                }
            }
        }

        if (sell > buy) {
            profit += (sell - buy);
        }

        return profit;
    }

    @Override
    public void run() {
        System.out.println(this.maxProfit(new int[] { 2, 4, 1}));
        System.out.println(this.maxProfit(new int[] { 1, 4, 1, 6}));
        System.out.println(this.maxProfit(new int[] { 1, 4, 2, 6}));
        System.out.println(this.maxProfit(new int[] { 1, 4, 3, 6}));
        System.out.println(this.maxProfit(new int[] { 1, 4, 4, 6}));
        System.out.println(this.maxProfit(new int[] { 1, 4, 5, 6}));
        System.out.println(this.maxProfit(new int[] { 1, 4, 6, 6}));
        System.out.println(this.maxProfit(new int[] { 1, 4, 7, 6}));
        System.out.println(this.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
        System.out.println(this.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(this.maxProfit(new int[] { 7, 1, 3, 1, 6, 4 }));
        System.out.println(this.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(this.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }
}
