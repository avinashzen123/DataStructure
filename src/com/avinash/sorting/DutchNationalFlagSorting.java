package com.avinash.sorting;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/description/
 * 
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 * 
 */
public class DutchNationalFlagSorting {
	public void sortColors(int[] nums) {
		int fromStart = 0;
		int fromEnd = nums.length - 1;
		int curr = 0;
		while (curr <= fromEnd) {
			if (nums[curr] == 0) {
				swap(nums, fromStart++, curr++);
			} else if (nums[curr] == 2) {
				swap(nums, fromEnd--, curr);
			} else {
				curr++;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {2,0,2,1,1,0};
		new DutchNationalFlagSorting().sortColors(array);
		System.out.println(Arrays.toString(array));
	}
}
