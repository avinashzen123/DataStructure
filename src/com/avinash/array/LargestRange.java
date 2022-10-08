package com.avinash.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {
	/*
	 * Write a function that takes in an array of integers and returns an array of
	 * length 2 representing the largest range of integers contained in that array.
	 * 
	 * The first number in the output array should be the first number in the range,
	 * while the second number should be the last number in the range.
	 * 
	 * A range of numbers is defined as a set of numbers that come right after each
	 * other in the set of real integers. For instance, the output array [2, 6]
	 * represents the range {2, 3, 4, 5, 6}
	 * 
	 * , which is a range of length 5. Note that numbers don't need to be sorted or
	 * adjacent in the input array in order to form a range.
	 * 
	 * You can assume that there will only be one largest range.
	 * 
	 * Sample Input : [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6] Sample Output: [0, 7]
	 * 
	 */
	public static int[] largestRange(int[] array) {
		Map<Integer, Boolean> map = new HashMap<>();
		int max = 0;
		int result[] = new int[2];
		for (int i : array) {
			map.put(i, true);
		}
		for (int i : array) {
			if (map.containsKey(i) && map.get(i)) {
				int left = i - 1;
				int right = i + 1;
				while (map.containsKey(left)) {
					map.put(left--, false);
				}
				while (map.containsKey(right)) {
					map.put(right++, false);
				}
				if (right - left > max) {
					max = right - left;
					result[0] = left + 1;
					result[1] = right - 1;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(largestRange(new int[] { 1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6 })));
	}
}
