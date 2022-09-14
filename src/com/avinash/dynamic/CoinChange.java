package com.avinash.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChanging.java
public class CoinChange {

	/**
	 * https://leetcode.com/problems/coin-change/
	 * 
	 * You are given an integer array coins representing coins of different
	 * denominations and an integer amount representing a total amount of money.
	 * 
	 * Return the fewest number of coins that you need to make up that amount. If
	 * that amount of money cannot be made up by any combination of the coins,
	 * return -1.
	 * 
	 * You may assume that you have an infinite number of each kind of coin.
	 * 
	 * Input: coins = [1,2,5], amount = 11 Output: 3
	 * 
	 * Explanation: 11 = 5 + 5 + 1
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Arrays.sort(coins);
		dp[0] = 0;
		for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
			for (int coin : coins) {
				if (currentAmount - coin >= 0) {
					dp[currentAmount] = Math.min(dp[currentAmount], 1 + dp[currentAmount - coin]);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[amount] == Integer.MAX_VALUE || dp[amount] < 0 ? -1 : dp[amount];
	}

	/**
	 * https://leetcode.com/problems/coin-change-ii/
	 * 
	 * You are given an integer array coins representing coins of different
	 * denominations and an integer amount representing a total amount of money.
	 * 
	 * Return the number of combinations that make up that amount. If that amount of
	 * money cannot be made up by any combination of the coins, return 0.
	 * 
	 * You may assume that you have an infinite number of each kind of coin.
	 * 
	 * The answer is guaranteed to fit into a signed 32-bit integer.
	 * 
	 * Input: amount = 5, coins = [1,2,5] Output: 4 Explanation: there are four ways
	 * to make up the amount: 5=5 5=2+2+1 5=2+1+1+1 5=1+1+1+1+1
	 * 
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int combinationOfCoinChange(int[] coins, int amount) {
		List<List<Integer>> result = new ArrayList<>();
		combinationOfCoinChange(coins, amount, 0, 0, result, new ArrayList<>());
		System.out.println(result);
		return result.size();
	}

	private static void combinationOfCoinChange(int[] coins, int amount, int currentAmount,int curIndex, List<List<Integer>> combinations, List<Integer> curCombination) {
		if (amount == currentAmount) {
			combinations.add(new ArrayList<>(curCombination));
			return;
		}
		if (curIndex >= coins.length) return;
		if (currentAmount + coins[curIndex] <= amount) {
			curCombination.add(coins[curIndex]);
			combinationOfCoinChange(coins, amount, currentAmount + coins[curIndex], curIndex, combinations, curCombination);
			curCombination.remove(curCombination.size() - 1);
		}
		combinationOfCoinChange(coins, amount, currentAmount, curIndex + 1, combinations, curCombination);
	}
	
	public static int combinationOfCoinChangeDP(int[] coins, int amount) {
		int temp[][] = new int[coins.length + 1][amount + 1];
		for (int i = 0; i <= coins.length; i++) temp[i][0] = 1;
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j < coins[i - 1]) {
					temp[i][j] = temp[i - 1][j];
				} else {
					temp[i][j] = temp[i - 1][j] + temp[i][j - coins[i - 1]];
				}
			}
		}
		return temp[coins.length][amount];
	}
	
	public static void main(String[] args) {
		int[] coins = new int[] { 1, 3, 4, 5 };
		int amount = 11;

//		int[] coins = new int[] {3};
//		int amount = 2;
//		System.out.println(coinChange(coins, amount));

//		int[] coins1 = new int[] {186,419,83,408};
//		int amount1 = 6249;
//		System.out.println(coinChange(coins1, amount1));
		
		System.out.println(combinationOfCoinChangeDP(new int[] {2}, 3));
		
//		System.out.println(combinationOfCoinChangeDP(new int[] {1,2,5}, 5));
//		
//		System.out.println(combinationOfCoinChangeDP(new int[] {3,5,7,8,9,10,11}, 500));
	}
}
