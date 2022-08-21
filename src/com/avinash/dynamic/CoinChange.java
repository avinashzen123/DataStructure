package com.avinash.dynamic;

import java.util.stream.IntStream;

public class CoinChange {

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		IntStream.range(0, amount+1).forEach(i -> dp[i] = amount);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coin]);					
				}
			}
		}
		return dp[amount] == 0? -1 : dp[amount];
	}
	
	public static void main(String[] args) {
		int[] coins = new int[] {1,3,4,5};
		int amount = 7;
		System.out.println(coinChange(coins, amount));
	}
}
