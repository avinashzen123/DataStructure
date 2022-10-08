package com.avinash.array;

import java.util.Arrays;

public class SubArraySort {
	/*
	 * Write a function that takes array of atleast two integer return array of
	 * start index and end index of smallest subarray int the input array that needs
	 * to be sorted in place order for entire array to be sorted in ascending order
	 */
	public static int[] subarraySort(int[] array) {
		// Write your code here.
		int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;
		for (int i = 1; i < array.length; i++) {
			if (isOutOfOrder(i, array)) {
				minOutOfOrder = Math.min(minOutOfOrder, array[i]);
				maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
			}
		}
		if (minOutOfOrder == Integer.MAX_VALUE) {
			return new int[] { -1, -1 };
		}
		int startIdx = 0;
		int endIdx = array.length - 1;
		while (minOutOfOrder >= array[startIdx]) {
			startIdx++;
		}
		while (maxOutOfOrder <= array[endIdx]) {
			endIdx--;
		}
		return new int[] { startIdx, endIdx };
	}

	private static boolean isOutOfOrder(int i, int[] array) {
		if (i == 0) {
			return array[i] > array[i+1];
		}
		if (i + 1 == array.length) {
			return array[i-1] > array[i];
		}
		return array[i] > array[i+1] || array[i-1] > array[i];
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(subarraySort(new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19 })));
	}
}
