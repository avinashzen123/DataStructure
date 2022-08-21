package com.avinash.dynamic;

import java.util.stream.IntStream;

public class StairCaseProblem {
	private int[] dp;
	public StairCaseProblem(int n) {
		dp = new int[n];
		IntStream.range(0, n).forEach(i -> dp[i] = -1);
	}
	public int stairs(int n) {
		if (n <=2) return n;
		if (dp[n-1] != -1) return dp[n];
		dp[n-1] = stairs(n-1) + stairs(n - 2);
		return dp[n-1];
	}
	
	public static void main(String[] args) {
		StairCaseProblem caseProblem = new StairCaseProblem(5);
		System.out.println(caseProblem.stairs(5));
	}
}
