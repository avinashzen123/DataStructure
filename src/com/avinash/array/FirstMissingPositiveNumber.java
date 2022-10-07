package com.avinash.array;

import java.util.Arrays;

public class FirstMissingPositiveNumber {
	public static int firstMissingPositive(int[] nums) {

		int index = 0;
		while (index < nums.length) {
			int curValue = nums[index] - 1;
			if (curValue >= 0 & curValue < nums.length && nums[curValue] != nums[index]) {
				swap(nums, curValue, index);
			} else {
				index++;
			}
		}
		System.out.println(Arrays.toString(nums));
		for (index = 0; index < nums.length; index++) {
			if (nums[index] != index + 1) {
				return index + 1;
			}
		}

		return nums.length + 1;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(firstMissingPositive(new int[] { 0, 1, 9, -3, 8}));
		System.out.println(firstMissingPositive(new int[] {1}));
	}
}
