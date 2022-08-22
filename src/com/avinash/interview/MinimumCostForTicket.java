package com.avinash.interview;

import java.util.Arrays;
import java.util.TreeMap;

// https://leetcode.com/problems/minimum-cost-for-tickets/
public class MinimumCostForTicket {
	
	public static void main(String[] args) {
		int[] days = {1,4,6,7,8,20};
//		int[] costs = {2,7,15};
		int[] costs = {7, 2,15};
		System.out.println(minimumCost(days, costs));
	}
	
	public static int minimumCost(int[] days, int[] costs) {
		int[] dpTable = new int[days.length + 1];
		int[] costDays = {1,7,30};
		for (int day = days.length - 1; day >= 0; day--) {
			dpTable[day] = Integer.MAX_VALUE;
			for (int costIndex = 0; costIndex < costs.length; costIndex++) {
				int j = day;
				while (j < days.length && days[j] < days[day] + costDays[costIndex]) {
					j ++;
				}
				dpTable[day] = Math.min(dpTable[day], (dpTable[j] == Integer.MAX_VALUE ? 0 : dpTable[j])  + costs[costIndex]);
			}
		}
		return dpTable[0];
	}

}
