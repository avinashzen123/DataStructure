package com.avinash.dynamic.oned;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinCostClimbing {

	public static int minCostClimbingStairs(int[] cost) {
		List<Integer> climbinCost = Arrays.stream(cost).boxed().collect(Collectors.toList());
		climbinCost.add(0);
		for (int i = climbinCost.size() - 3; i >= 0; i --) {
			climbinCost.set(i, climbinCost.get(i) + Math.min(climbinCost.get(i+1), climbinCost.get(i+2)));
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
        return dp[cost.length ];
    }
	
	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] {10, 15, 20}));
	}
}
