package com.avinash.dynamic;

import java.util.stream.IntStream;

public class StairCaseProblem {

	public int climbStairs(int n) {
		int[] dp = new int[n];
		IntStream.range(0, n).forEach(i -> dp[i] = -1);
		return climbStaires(n, dp);
	}

	private int climbStaires(int n, int[] dp) {
		if (n <= 2) return n;
		if (dp[n - 1] != -1) return dp[n - 1];
		dp[n - 1] = climbStaires(n - 1, dp) + climbStaires(n - 2, dp);
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int floors = 6;
		StairCaseProblem caseProblem = new StairCaseProblem();
		System.out.println(caseProblem.climbStairs(floors));
	}
}
