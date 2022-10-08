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
	
	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] {10, 15, 20}));
	}
}
