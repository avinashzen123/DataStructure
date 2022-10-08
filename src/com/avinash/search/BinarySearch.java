package com.avinash.search;

import java.util.Arrays;

public class BinarySearch {

	public static int find(int[] container, int item, int left, int right) {
		if (right < left)
			return -1;
		int middle_index = (left + right) / 2;
		if (container[middle_index] == item)
			return middle_index;
		else if (container[middle_index] < item)
			return find(container, item, middle_index + 1, right);
		else if (container[middle_index] > item)
			return find(container, item, left, middle_index - 1);
		return left;
	}

	public static boolean search2DMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;
		int numberOfRow = matrix.length;
		int numberOfCols = matrix[0].length;
		int start = 0;
		int end = numberOfCols * numberOfRow - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int midRow = mid / numberOfCols;
			int midCol = mid % numberOfCols;

			if (matrix[midRow][midCol] == target) {
				return true;
			} else if (matrix[midRow][midCol] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	public static boolean search2DBinarySearch(int[][] matrix, int target) {
		for (int low = 0, high = matrix.length - 1; low < matrix.length && high >= 0;) {
			if (matrix[low][high] == target) {
				return true;
			} else if (matrix[low][high] < target) {
				low++;
			} else {
				high--;
			}
		}
		return false;
	}

	/*
	 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
	 * piles[i] bananas. The guards have gone and will come back in h hours.
	 * 
	 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
	 * chooses some pile of bananas and eats k bananas from that pile. If the pile
	 * has less than k bananas, she eats all of them instead and will not eat any
	 * more bananas during this hour.
	 * 
	 * Koko likes to eat slowly but still wants to finish eating all the bananas
	 * before the guards return.
	 * 
	 * Return the minimum integer k such that she can eat all the bananas within h
	 * hours.
	 * 
	 * 
	 * Input: piles = [3,6,7,11], h = 8 Output: 4
	 * 
	 * 
	 * Input: piles = [30,11,23,4,20], h = 5 Output: 30
	 * 
	 * 
	 */
	public static int minEatingSpeed(int[] piles, int h) {
		int low = 0;
		int high = Arrays.stream(piles).max().getAsInt();
		while (low < high) {
			int mid = (high + low) / 2;
			int requiredTime = Arrays.stream(piles).reduce(0, (i, j) -> i + (int) Math.ceil(((double) j / mid)));
			if (requiredTime <= h) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}

	/*
	 * There is an integer array nums sorted in ascending order (with distinct
	 * values).
	 * 
	 * Prior to being passed to your function, nums is possibly rotated at an
	 * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
	 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
	 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
	 * and become [4,5,6,7,0,1,2].
	 * 
	 * Given the array nums after the possible rotation and an integer target,
	 * return the index of target if it is in nums, or -1 if it is not in nums.
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
	 * 
	 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
	 */
	public static int searchInRotatedArray(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (right + left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[left] <= nums[mid]) {
				if (target > nums[mid] || target < nums[left]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (target < nums[mid] || target > nums[right]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}

	/*
	 * Suppose an array of length n sorted in ascending order is rotated between 1
	 * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
	 * 
	 * [4,5,6,7,0,1,2] if it was rotated 4 times. [0,1,2,4,5,6,7] if it was rotated
	 * 7 times.
	 * 
	 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
	 * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
	 * 
	 * Given the sorted rotated array nums of unique elements, return the minimum
	 * element of this array.
	 * 
	 * You must write an algorithm that runs in O(log n) time.
	 * 
	 * Input: nums = [3,4,5,1,2] Output: 1 Explanation: The original array was
	 * [1,2,3,4,5] rotated 3 times.
	 * 
	 */
	public static  int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] < nums[right]) {
				return nums[left];
			}
			int mid = (right + left) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return nums[0];
	}

	public static void main(String[] args) {
		int[] array = { -40, -2, 0, 1, 2, 5, 6, 11, 32 };
		System.out.println(find(array, 2, 0, array.length - 1));
		int[][] arr = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(search2DMatrix(arr, 16));
		System.out.println(search2DBinarySearch(arr, 24));
		System.out.println(minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
		System.out.println(searchInRotatedArray(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		System.out.println(findMin(new int[] {1,2,3,4,5}));
	}
}
