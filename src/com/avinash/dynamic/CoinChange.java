package com.avinash.dynamic;

import java.util.Arrays;

public class CoinChange {

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
//		return dp[amount] == 0? -1 : dp[amount];
        return dp[amount] == Integer.MAX_VALUE || dp[amount] < 0 ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = new int[] {1,3,4,5};
		int amount = 11;
		
//		int[] coins = new int[] {3};
//		int amount = 2;
		System.out.println(coinChange(coins, amount));
		
//		int[] coins1 = new int[] {186,419,83,408};
//		int amount1 = 6249;
//		System.out.println(coinChange(coins1, amount1));
	}
}
