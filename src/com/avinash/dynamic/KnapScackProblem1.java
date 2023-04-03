package com.avinash.dynamic;

import java.util.Arrays;

public class KnapScackProblem1 {
	public static void main(String[] args) {
		int numOfItems = 4;
		int capacityOfKnapsack = 7;
		int[] weightOfItems = { 0, 1, 3, 4, 5 };
		int[] profitOfItems = { 0, 1, 4, 5, 7 };
		solve(weightOfItems, profitOfItems, capacityOfKnapsack, numOfItems);
		
	}

	public static void solve(int[] weights, int[] values, int capacity, int numberOfItems) {
		int[][] dpTable = new int[numberOfItems + 1][capacity + 1];
		
		for (int valIndex = 1; valIndex <= numberOfItems; valIndex++) {
			for (int weight = 1; weight <= capacity; weight++) {
				int notConsiderintCurrentItem = dpTable[valIndex - 1][weight];
				if (weights[valIndex] <= weight) {
					int remainingWeight = weight - weights[valIndex];
					dpTable[valIndex][weight] = Math.max(notConsiderintCurrentItem,
							values[valIndex] + dpTable[valIndex - 1][remainingWeight]);
				} else {
					dpTable[valIndex][weight] = notConsiderintCurrentItem;
				}
			}
		}
		Arrays.stream(dpTable).map(Arrays::toString).forEach(System.out::println);
		System.out.println("Total Benifit :" +  dpTable[numberOfItems][capacity]);
		for (int i = numberOfItems, w = capacity; i > 0; i--) {
			if(dpTable[i][w] != 0 && dpTable[i][w] != dpTable[i-1][w]) {
				System.out.println("We take item # " +i);
				w = w - weights[i];
			}
		}
	}
}
