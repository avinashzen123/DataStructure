package com.avinash.dynamic.oned;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/min-cost-climbing-stairs/
/**
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * Input: cost = [10,15,20]
 * 
 * Output: 15
 * 
 * Explanation: You will start at index 1. - Pay 15 and climb two steps to reach
 * the top. The total cost is 15.
 */
public class MinCostClimbing {

	public static int minCostClimbingStairs(int[] cost) {
		List<Integer> climbinCost = Arrays.stream(cost).boxed().collect(Collectors.toList());
		climbinCost.add(0);
		for (int i = climbinCost.size() - 3; i >= 0; i--) {
			climbinCost.set(i, climbinCost.get(i) + Math.min(climbinCost.get(i + 1), climbinCost.get(i + 2)));
		}
		System.out.println(climbinCost);
		return Math.min(climbinCost.get(0), climbinCost.get(1));
	}

	public int minCostClimbingStairs1(int[] cost) {
		int dp[] = new int[cost.length + 1];
		for (int i = 2; i <= cost.length; i++) {
			// dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
			int oneStep = cost[i - 1] + dp[i - 1];
			int twoStep = cost[i - 2] + dp[i - 2];
			dp[i] = Math.min(oneStep, twoStep);
		}
		System.out.println(Arrays.toString(dp));
		return dp[cost.length];
	}

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }));
	}
}
