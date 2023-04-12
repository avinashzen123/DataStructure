package com.avinash.dynamic.oned;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-profit-from-trading-stocks/description/
/**
 * You are given two 0-indexed integer arrays of the same length present and
 * future where present[i] is the current price of the ith stock and future[i]
 * is the price of the ith stock a year in the future. You may buy each stock at
 * most once. You are also given an integer budget representing the amount of
 * money you currently have.
 * 
 * Return the maximum amount of profit you can make.
 * 
 * Input: present = [5,4,6,2,3], future = [8,5,4,3,5], budget = 10
 * 
 * Output: 6
 * 
 * Explanation: One possible way to maximize your profit is to: Buy the 0th,
 * 3rd, and 4th stocks for a total of 5 + 2 + 3 = 10. Next year, sell all three
 * stocks for a total of 8 + 3 + 5 = 16. The profit you made is 16 - 10 = 6. It
 * can be shown that the maximum
 */
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
		int[] present = { 5, 4, 6, 2, 3 };
		int[] future = { 8, 5, 4, 3, 5 };
		int budge = 10;
		System.out.println(maximumProfit(present, future, budge));
	}
}
