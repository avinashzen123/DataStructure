package com.avinash.array;

public class MaxConsecutiveOneByFlipping0s {
	/*
	 * https://leetcode.com/problems/max-consecutive-ones-iii/
	 * 
	 * Given a binary array nums and an integer k, return the maximum number of
	 * consecutive 1's in the array if you can flip at most k 0's.
	 * 
	 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0],
	 * 
	 * k = 2
	 * 
	 * Output: 6
	 * 
	 * Explanation: [1,1,1,0,0,1,1,1,1,1,1] Bolded numbers were flipped from 0 to 1.
	 * The longest subarray is underlined.
	 * 
	 */
	public static int longestOnes(int[] nums, int k) {
		int result = 0;
		int left = 0;
		int countZero = 0;
		for (int right = 0; right < nums.length; right++) {
			if (nums[right] == 0)
				countZero++;
			while (countZero > k) {
				if (nums[left] == 0) {
					countZero--;
				}
				left++;
			}
			result = Math.max(result, right - left + 1);
		}
		return result;
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] == 1) {
				int k = index;
				while (k < nums.length && nums[k] == 1) {
					k++;
				}
				max = Math.max(max, k - index);
				index = k;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
		System.out.println(longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
		System.out.println(longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
	}
}
