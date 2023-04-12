package com.avinash.dynamic;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/

/**
 * 
 * Given two integer arrays nums1 and nums2, return the maximum length of a
 * subarray that appears in both arrays.
 * 
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7] Output: 3 Explanation: The
 * repeated subarray with maximum length is [3,2,1].
 * 
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0] Output: 5 Explanation: The
 * repeated subarray with maximum length is [0,0,0,0,0].
 *
 */
public class MaxLengthRepeatedSubArray {
	public int findLength(int[] nums1, int[] nums2) {
		int ans = 0;
		int[][] memo = new int[nums1.length + 1][nums2.length + 1];
		for (int i = nums1.length - 1; i >= 0; i--) {
			for (int j = nums2.length - 1; j >= 0; j--) {
				if (nums1[i] == nums2[j]) {
					memo[i][j] = 1 + memo[i + 1][j + 1];
					ans = Math.max(ans, memo[i][j]);
				}
			}
		}
		Arrays.stream(memo).map(Arrays::toString).forEach(System.out::println);
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
		System.out.println(new MaxLengthRepeatedSubArray().findLength(nums1, nums2));
	}
}
