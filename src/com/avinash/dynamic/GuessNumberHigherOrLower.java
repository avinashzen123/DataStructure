package com.avinash.dynamic;

import java.util.Arrays;

// https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/

public class GuessNumberHigherOrLower {

	static class DP {
		static int getMoneyAmount(int n) {
			int rows = n + 2;
			int cols = n + 2;
			int[][] dp = new int[rows][cols];
			for (int lenSubArray = 1; lenSubArray < n; lenSubArray++) {
				for (int start = 1; start + lenSubArray <= n; start++) {
					int end = start + lenSubArray;
					dp[start][end] = Integer.MAX_VALUE;
					for (int guess = start; guess <= end; guess++) {
						int leftGuess = dp[start][guess - 1];
						int rightGess = dp[guess + 1][end];
						int costOfGuess = guess + Math.max(leftGuess, rightGess);
						int currentGuess = dp[start][end];
						dp[start][end] = Math.min(currentGuess, costOfGuess);
						Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
						System.out
								.println("----------------------" + start + "---------" + end + "----Guess---" + guess);
					}
				}
			}
			Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
			return dp[1][n];
		}
	}

	static class DPMemoization {
		static int findMinMoneyDPMem(int[][] dp, int start, int end) {

			// Base Cases
			if (start >= end)
				return 0;
			if (dp[start][end] != -1)
				return dp[start][end];

			int minMoney = Integer.MAX_VALUE;
			for (int i = start; i <= end; i++)
				minMoney = Math.min(minMoney,
						i + Math.max(findMinMoneyDPMem(dp, start, i - 1), findMinMoneyDPMem(dp, i + 1, end)));

			dp[start][end] = minMoney;

			return dp[start][end];
		}
		
		static int getMoneyAmount(int n) {
			int[][] dp = new int[n+1][n+1];
			for(int i = 0; i <= n; i++) {
				Arrays.fill(dp[i], -1);
			}
			return findMinMoneyDPMem(dp, 1, n);
		}
	}

	static class Recursion {
		static int findMinMoneyRec(int start, int end) {
			if (start >= end) {
				return 0;
			}
			int minMoney = Integer.MAX_VALUE;
			for (int i = start; i <= end; i++) {
				minMoney = Math.min(minMoney, i + Math.max(findMinMoneyRec(start, i - 1), findMinMoneyRec(i + 1, end)));
			}
			return minMoney;
		}

		static int getMoneyAmount(int n) {
			return findMinMoneyRec(1, n);
		}
	}

	public static void main(String[] args) {
		System.out.println(Recursion.getMoneyAmount(10));
		System.out.println(DPMemoization.getMoneyAmount(10));
	}
}
