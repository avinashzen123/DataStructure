package com.avinash.interview;

public class LargestSubarray {

	public static int solve(int[] array) {
		int currentSum = array[0];
		int globalSum = array[0];

		for (int i = 1; i < array.length; i++) {
			currentSum = Math.max(array[i], currentSum + array[i]);
			globalSum = Math.max(currentSum, globalSum);
		}
		return globalSum;
	}

	public static void main(String[] args) {
		System.out.println(solve(new int[] { 1, -2, 3, 4, -5, 8 }));
	}
}
