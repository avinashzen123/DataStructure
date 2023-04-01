package com.avinash.sorting;

import java.util.Arrays;

/**
 * Given an integer array nums, reorder it such that nums[0] <= nums[1] >=
 * nums[2] <= nums[3].... You may assume the input array always has a valid
 * answer.
 * 
 * Input: nums = [3,5,2,1,6,4] Output: [3,5,1,6,2,4] Explanation: [1,6,2,5,3,4]
 * is also accepted.
 * 
 * https://leetcode.com/problems/wiggle-sort/description/
 */
public class WiggleSort {
	/*
	 * Time complexity : o(n log(n))
	 */
	public static void usingSorting(int[] array) {
		Arrays.sort(array);
		for (int i = 1; i < array.length - 1; i = i + 2) {
			swap(array, i);
		}
	}

	private static void swap(int[] array, int i) {
		int tmp = array[i];
		array[i] = array[i + 1];
		array[i + 1] = tmp;
	}

	/*
	 * Time complexity : O(n)
	 */
	public static void greedySorting(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if ((i % 2 == 0 && array[i] > array[i + 1]) || (i % 2 != 0 && array[i] < array[i + 1])) {
				swap(array, i);
			}
		}
	}

	// https://leetcode.com/problems/wiggle-sort-ii/
	public static void wiggleSortWithDuplicates(int[] nums) {
		int[] arr = nums.clone();
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int n = nums.length;
		int i = (n - 1) >> 1, j = n - 1;
		
		for (int x = 0; x < n; ++x) {
			if (x % 2 == 0) {
				nums[x] = arr[i--];
			} else {
				nums[x] = arr[j--];
			}
		}
	}

	public static void main(String[] args) {
//		int[] array = { 3, 5, 2, 1, 6, 4 };
//		usingSorting(array);
//		System.out.println(Arrays.toString(array));
//		array = new int[] { 3, 5, 2, 1, 6, 4 };
//		greedySorting(array);
//		System.out.println(Arrays.toString(array));
		
		int[] array1 = {5,5,5,4,4,4,4};
		wiggleSortWithDuplicates(array1);
		System.out.println(Arrays.toString(array1));
	}
}
