package com.avinash.dynamic;

import java.util.Arrays;

// https://leetcode.com/problems/partition-equal-subset-sum/submissions/
public class PartitionEqualSubSetSum {
	/*
	 * Given a non-empty array nums containing only positive integers, find if the
	 * array can be partitioned into two subsets such that the sum of elements in
	 * both subsets is equal.
	 * 
	 * Input: nums = [1,5,11,5] Output: true Explanation: The array can be
	 * partitioned as [1, 5, 5] and [11].
	 * 
	 * Input: nums = [1,2,3,5] Output: false Explanation: The array cannot be
	 * partitioned into equal sum subsets
	 */
	public static boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		if (sum % 2 != 0)
			return false;
		int target = sum / 2;
		boolean[][] table = new boolean[nums.length + 1][target + 1];
		for (int numIndex = 0; numIndex <= nums.length; numIndex++) {
			for (int curTarget = 0; curTarget <= target; curTarget++) {
				if (numIndex == 0 || curTarget == 0) {
					if (numIndex == 0) {
						table[numIndex][curTarget] = false;
					} else if (curTarget == 0) {
						table[numIndex][curTarget] = true;
					}
				} else if (curTarget >= nums[numIndex - 1]) {
					table[numIndex][curTarget] = table[numIndex - 1][curTarget]
							|| table[numIndex - 1][curTarget - nums[numIndex - 1]];
				} else {
					table[numIndex][curTarget] = table[numIndex - 1][curTarget];
				}
			}
		}
		return table[nums.length][target];
	}

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 14, 9, 8, 4, 3, 2 }));
	}
}
