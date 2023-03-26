package com.avinash.array;

// https://leetcode.com/problems/find-peak-element/description/
/**
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given a 0-indexed integer array nums, find a peak element, and return its
 * index. If the array contains multiple peaks, return the index to any of the
 * peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is
 * always considered to be strictly greater than a neighbor that is outside the
 * array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * 
 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your
 * function should return the index number 2.
 *
 * Input: nums = [1,2,1,3,5,6,4] Output: 5 Explanation: Your function can return
 * either index number 1 where the peak element is 2, or index number 5 where
 * the peak element is 6.
 */
public class PeakElement {
	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int middle = (left + right) / 2;
			if (nums[middle] > nums[middle + 1]) {
				right = middle;
			} else {
				left = middle + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		System.out.println(new PeakElement().findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
	}
}
