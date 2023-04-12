package com.avinash.dynamic;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/
/**
 * We are playing the Guessing Game. The game will work as follows:
 * 
 * I pick a number between 1 and n. You guess a number. If you guess the right
 * number, you win the game. If you guess the wrong number, then I will tell you
 * whether the number I picked is higher or lower, and you will continue
 * guessing. Every time you guess a wrong number x, you will pay x dollars. If
 * you run out of money, you lose the game.
 * 
 * Given a particular n, return the minimum amount of money you need to
 * guarantee a win regardless of what number I pick.
 * 
 */
public class GuessNumberHigherOrLower {

	static class DP {
		static int getMoneyAmount(int n) {
			int rows = n + 2;
			int cols = n + 2;
			int[][] dp = new int[rows][cols];
			int count = 0;
			for (int lenSubArray = 1; lenSubArray < n; lenSubArray++) {
				for (int start = 1; start + lenSubArray <= n; start++) {
					int end = start + lenSubArray;
					dp[start][end] = Integer.MAX_VALUE;
					for (int guess = start; guess <= end; guess++) {
						count++;
						int leftGuess = dp[start][guess - 1];
						int rightGess = dp[guess + 1][end];
						int costOfGuess = guess + Math.max(leftGuess, rightGess);
						int currentGuess = dp[start][end];
						dp[start][end] = Math.min(currentGuess, costOfGuess);
//						Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
//						System.out
//								.println("----------------------" + start + "---------" + end + "----Guess---" + guess);
					}
				}
			}
//			System.out.println(count);
//			Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
			return dp[1][n];
		}
	}

	static class DPMemoization {
		static int count;

		static int findMinMoneyDPMem(int[][] dp, int start, int end) {

			// Base Cases
			if (start >= end)
				return 0;
			if (dp[start][end] != -1)
				return dp[start][end];
			count++;
			int minMoney = Integer.MAX_VALUE;
			for (int i = start; i <= end; i++)
				minMoney = Math.min(minMoney,
						i + Math.max(findMinMoneyDPMem(dp, start, i - 1), findMinMoneyDPMem(dp, i + 1, end)));

			dp[start][end] = minMoney;

			return dp[start][end];
		}

		static int getMoneyAmount(int n) {
			int[][] dp = new int[n + 1][n + 1];
			for (int i = 0; i <= n; i++) {
				Arrays.fill(dp[i], -1);
			}
			return findMinMoneyDPMem(dp, 1, n);
		}
	}

	static class Recursion {
		static int count = 0;
		static Stack<String> stack = new Stack<>();
		static int findMinMoneyRec(int start, int end) {
			if (start >= end) {
				return 0;
			}
			count++;
			int minMoney = Integer.MAX_VALUE;
			for (int i = start; i <= end; i++) {
				String strLeft = String.format("findMinMoneyRec(%d, %d - 1)", start, i);
				System.out.println("Adding Index i " + i + " call " + strLeft);
				stack.push(strLeft);
				int left = findMinMoneyRec(start, i - 1);
				stack.remove(strLeft);
				System.err.println("Removing Index i " + i + " call " + strLeft +  " result " + left);
				String strRight = String.format("findMinMoneyRec(%d + 1, %d)", i, end);
				System.out.println("Adding Index i " + i + " call " + strRight);
				int right = findMinMoneyRec(i + 1, end);
				stack.remove(strRight);
				System.err.println("Removing Index i " + i + " call " + strRight + " result " + right);
				minMoney = Math.min(minMoney, i + Math.max(left, right));
				System.out.println("Index " + i  + " Min Money " + minMoney);
			}
			return minMoney;
		}

		static int getMoneyAmount(int n) {
			return findMinMoneyRec(1, n);
		}
	}

	public static void main(String[] args) {
		System.out.println(DP.getMoneyAmount(10));
		System.out.println(Recursion.getMoneyAmount(4));
		System.out.println("Recursion count = " + Recursion.count);
		System.out.println(DPMemoization.getMoneyAmount(10));
		System.out.println(DPMemoization.count);
	}
}
