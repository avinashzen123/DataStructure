package com.avinash.array;

// https://www.youtube.com/watch?v=8g78yfzMlao
public class FirstMissingPositive {
	/*
	 * https://leetcode.com/problems/first-missing-positive/
	 * 
	 * Given an unsorted integer array nums, return the smallest missing positive
	 * integer.
	 * 
	 * You must implement an algorithm that runs in O(n) time and uses constant
	 * extra space.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,2,0] Output: 3 Explanation: The numbers in the range [1,2]
	 * are all in the array. Example 2:
	 * 
	 * Input: nums = [3,4,-1,1] Output: 2 Explanation: 1 is in the array but 2 is
	 * missing. Example 3:
	 * 
	 * Input: nums = [7,8,9,11,12] Output: 1 Explanation: The smallest positive
	 * integer 1 is missing.
	 * 
	 */
	public int firstMissingPositive(int[] nums) {

		int index = 0;
		while (index < nums.length) {
			int curVal = nums[index] - 1;
			if (curVal >= 0 && curVal < nums.length && nums[curVal] != nums[index]) {
				swap(nums, index, curVal);
			} else {
				index++;
			}
		}
		for (index = 0; index < nums.length; index++) {
			if (nums[index] != index + 1) {
				return index + 1;
			}
		}
		return nums.length + 1;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}
}
