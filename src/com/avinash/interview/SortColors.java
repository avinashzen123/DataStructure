package com.avinash.interview;

import java.util.Arrays;

// https://leetcode.com/problems/sort-colors/description/
/**
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 *
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int fromStart = 0;
		int fromEnd = nums.length - 1;
		int curr = 0;
		while (curr <= fromEnd) {
			if (nums[curr] == 0) {
				swap(nums, curr++, fromStart++);
			} else if (nums[curr] == 2) {
				swap(nums, curr++, fromEnd--);
			} else {
				curr++;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		SortColors sortColor = new SortColors();
		int[] colors = new int[] { 2, 0, 2, 1, 1, 0 };
		sortColor.sortColors(colors);
		System.out.println(Arrays.toString(colors));
	}
}
