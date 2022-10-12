package com.avinash.array;

public class IncreasingTipletSequence {

	/*
	 * Given an integer array nums, return true if there exists a triple of indices
	 * (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such
	 * indices exists, return false.
	 *
	 * Input: nums = [1,2,3,4,5] Output: true Explanation: Any triplet where i < j <
	 * k is valid.
	 * 
	 * Input: nums = [5,4,3,2,1] Output: false Explanation: No triplet exists.
	 * 
	 * Input: nums = [2,1,5,0,4,6] Output: true Explanation: The triplet (3, 4, 5)
	 * is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
	 * 
	 */

	public static boolean increasingTriplet(int[] nums) {
		int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= min)
				min = num;
			else if (num < secondMin)
				secondMin = num;
			else if (num > secondMin)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));
	}
}
