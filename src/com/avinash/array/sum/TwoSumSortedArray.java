package com.avinash.array.sum;

import java.util.Arrays;
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSumSortedArray {
	static int[] twoSum(int[] numbers, int target) {
		int lo = 0;
		int hi = numbers.length - 1;
		while (lo < hi) {
			int sum = numbers[lo] + numbers[hi];
			if (sum == target) {
				return new int[] { lo + 1, hi + 1 };
			} else if (sum < target) {
				lo++;
			} else {
				hi--;
			}
		}
		return new int[] { -1, -1 };
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
	}
	
}
