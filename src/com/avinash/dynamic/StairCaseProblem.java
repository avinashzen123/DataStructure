package com.avinash.dynamic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StairCaseProblem {

	public int climbStairs(int n) {
		int[] dp = new int[n];
		IntStream.range(0, n).forEach(i -> dp[i] = -1);
		return climbStaires(n, dp);
	}

	private int climbStaires(int n, int[] dp) {
		if (n <= 2)
			return n;
		if (dp[n - 1] != -1)
			return dp[n - 1];
		dp[n - 1] = climbStaires(n - 1, dp) + climbStaires(n - 2, dp);
		return dp[n - 1];
	}

	public int staircaseTraversal(int height, int maxSteps) {
		if (height <= 1) {
			return 1;
		}
		int[] ways = new int[height + 1];
		ways[0] = 1;
		ways[1] = 1;
		for (int i = 2 ; i <= height; i++) {
			int count = 0;
			for (int j = 1; j <= maxSteps; j++) {
				if (i - j >= 0) {
					count += ways[i - j];
				}
			}
			ways[i] = count;
		}
		System.out.println(Arrays.toString(ways));
		return ways[height];
		
		
	}

	public static void main(String[] args) {
		int floors = 6;
		StairCaseProblem caseProblem = new StairCaseProblem();
//		System.out.println(caseProblem.climbStairs(floors));
		System.out.println(caseProblem.staircaseTraversal(4, 2));  // 5
//		System.out.println(caseProblem.staircaseTraversal(4, 3)); //7
	}
}
