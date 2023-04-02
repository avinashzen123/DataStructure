package com.avinash.dynamic.oned;

import java.util.Arrays;

public class MaxProfitFromTradingStock {

	static int maximumProfit(int[] present, int[] future, int budget) {
		int[] dp = new int[budget + 1];
		for (int stockIdx = 0; stockIdx < present.length; stockIdx++) {
			for (int curBudget = budget; curBudget >= 0; curBudget--) {
				if (curBudget >= present[stockIdx] && present[stockIdx] < future[stockIdx]) {
//					dp[curBudget] = Math.max(dp[curBudget], dp[curBudget - present[stockIdx]] + future[stockIdx] - present[stockIdx]);
					int prevProfitOnCurPurchase = dp[curBudget - present[stockIdx]];
                    int profitOnCurPurchase = future[stockIdx] - present[stockIdx];
                    dp[curBudget] = Math.max(dp[curBudget], prevProfitOnCurPurchase + profitOnCurPurchase);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[budget];
	}
	
	public static void main(String[] args) {
		int[] present = {5,4,6,2,3};
		int[] future = {8,5,4,3,5};
		int budge = 10;
		System.out.println(maximumProfit(present, future, budge));
	}
}
