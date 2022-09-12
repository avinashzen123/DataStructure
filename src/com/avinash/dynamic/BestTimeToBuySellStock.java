package com.avinash.dynamic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestTimeToBuySellStock {

	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 * 
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day.
	 * 
	 * You want to maximize your profit by choosing a single day to buy one stock
	 * and choosing a different day in the future to sell that stock.
	 * 
	 * Return the maximum profit you can achieve from this transaction. If you
	 * cannot achieve any profit, return 0.
	 * 
	 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
	 * and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2
	 * and selling on day 1 is not allowed because you must buy before you sell
	 * 
	 * Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no
	 * transactions are done and the max profit = 0.
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfilt(int[] prices) {
		int left = 0;
		int maxProfit = 0;
		for (int right = 0; right < prices.length; right++) {
			if (prices[left] < prices[right]) {
				maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
			} else {
				left = right;
			}
		}
		return maxProfit;
	}

	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	 * 
	 * You are given an integer array prices where prices[i] is the price of a given
	 * stock on the ith day.
	 * 
	 * On each day, you may decide to buy and/or sell the stock. You can only hold
	 * at most one share of the stock at any time. However, you can buy it then
	 * immediately sell it on the same day.
	 * 
	 * Find and return the maximum profit you can achieve.
	 * 
	 * Input: prices = [7,1,5,3,6,4] Output: 7 Explanation: Buy on day 2 (price = 1)
	 * and sell on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 (price =
	 * 3) and sell on day 5 (price = 6), profit = 6-3 = 3. Total profit is 4 + 3 =
	 * 7.
	 * 
	 * Input: prices = [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1)
	 * and sell on day 5 (price = 5), profit = 5-1 = 4. Total profit is 4.
	 * 
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit2(int[] prices) {
		int totalProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				int j = i + 1;
				while (j + 1 < prices.length && (prices[j] < prices[j + 1]))
					j++;
				totalProfit = totalProfit + (prices[j] - prices[i]);
				i = j + 1;
			}
		}
		return totalProfit;
	}

	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
	 * 
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day.
	 * 
	 * Find the maximum profit you can achieve. You may complete at most two
	 * transactions.
	 * 
	 * Note: You may not engage in multiple transactions simultaneously (i.e., you
	 * must sell the stock before you buy again).
	 * 
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit3(int[] prices) {
		List<Integer> queue = new ArrayList<>();
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				int j = i;
				while ((j + 1 < prices.length && prices[j] < prices[j + 1])
						|| (j + 2 < prices.length && prices[j] < prices[j + 2]))
					j++;
				queue.add(prices[j] - prices[i]);
				i = j;
			}
		}
		queue.sort(Comparator.reverseOrder());
		System.out.println(queue);
		return queue.size() == 0 ? 0 : queue.size() == 1 ? queue.get(0) : queue.get(0) + queue.get(1);
	}

	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
	 * 
	 * You are given an integer array prices where prices[i] is the price of a given
	 * stock on the ith day, and an integer k.
	 * 
	 * Find the maximum profit you can achieve. You may complete at most k
	 * transactions.
	 * 
	 * Note: You may not engage in multiple transactions simultaneously (i.e., you
	 * must sell the stock before you buy again).
	 * 
	 * Input: k = 2, prices = [3,2,6,5,0,3] Output: 7 Explanation: Buy on day 2
	 * (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day
	 * 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
	 * 
	 * 
	 * @param prices
	 * @param transactions
	 * @return
	 */
	public static int maxProfit4(int[] prices, int transactions) {
		int[][] dp = new int[transactions + 1][prices.length];
		for (int transaction = 1; transaction < transactions + 1; transaction++) {
			for (int priceIndex = 1; priceIndex < prices.length; priceIndex++) {
				int maxProfit = 0;
				for (int currPriceIndex = 0; currPriceIndex < priceIndex; currPriceIndex++) {
					maxProfit = Math.max(maxProfit,
							prices[priceIndex] - prices[currPriceIndex] + dp[transaction - 1][currPriceIndex]);
				}
				dp[transaction][priceIndex] = Math.max(dp[transaction][priceIndex - 1], maxProfit);
			}
		}
		return dp[transactions][prices.length - 1];
	}

	public static int maxProfit4_1(int[] prices, int transactions) {
		if (prices.length < 2)
			return 0;
		int[][] dp = new int[transactions + 1][prices.length];
		for (int transaction = 1; transaction < transactions + 1; transaction++) {
			int maxDiff = -prices[0];
			for (int priceIndex = 1; priceIndex < prices.length; priceIndex++) {
				dp[transaction][priceIndex] = Math.max(prices[priceIndex] + maxDiff, dp[transaction][priceIndex - 1]);
				maxDiff = Math.max(maxDiff, dp[transaction - 1][priceIndex] - prices[priceIndex]);
			}
		}
		return dp[transactions][prices.length - 1];
	}

	public static void main(String[] args) {
//		System.out.println(maxProfilt(new int[] { 7, 1, 5, 3, 6, 4 }));

		// int[] prices = new int[] {7,1,5,3,6,4};
		int[] prices = new int[] { 1, 2, 3, 4, 5 };
//		System.out.println(maxProfit2(prices));

		// int[] prices1 = new int[]{3,2,6,5,0,3};
		// int[] prices1 = new int[]{3,3,5,0,0,3,1,4};
		// int[] prices1 = new int[] {1,2,4,2,5,7,2,4,9,0};
//		int[] prices1 = new int[] { 6, 1, 3, 2, 4, 7 };
//		System.out.println(maxProfit3(prices1));

		System.out.println(maxProfit4_1(new int[] { 3, 2, 6, 5, 0, 3 }, 2));

	}
}
