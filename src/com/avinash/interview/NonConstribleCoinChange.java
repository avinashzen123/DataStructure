package com.avinash.interview;

import java.util.Arrays;

public class NonConstribleCoinChange {

	public static int findPossibleChangeRecurively(int[] coins) {
		Arrays.sort(coins);
		int minCoinChange = 0;
		for(int coin: coins) {
			if (coin > minCoinChange + 1) {
				break;
			}
			minCoinChange += coin;
		}
		return minCoinChange + 1;
	}	
	
	public static void main(String[] args) {
		int[] coins = new int[] {5,7,1,1,2,3,22};
//		int[] coins = new int[] {1,2,4};
		System.out.println(findPossibleChangeRecurively(coins));
	}
}
