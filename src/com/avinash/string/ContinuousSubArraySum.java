package com.avinash.string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/continuous-subarray-sum/description/
/**
 * Given an integer array nums and an integer k, return true if nums has a good
 * subarray or false otherwise.
 * 
 * A good subarray is a subarray where:
 * 
 * its length is at least two, and the sum of the elements of the subarray is a
 * multiple of k.
 * 
 * Note that:
 * 
 * A subarray is a contiguous part of the array. An integer x is a multiple of k
 * if there exists an integer n such that x = n * k. 0 is always a multiple of
 * k.
 * 
 * Input: nums = [23,2,4,6,7], k = 6
 * 
 * Output: true Explanation: [2, 4] is a continuous subarray of size 2 whose
 * elements sum up to 6.
 */
public class ContinuousSubArraySum {

	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(0, 0);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int remainder = sum % k;
			if (!hashMap.containsKey(remainder)) 
				hashMap.put(remainder, i + 1);
			else if (hashMap.get(remainder) < i)
				return true;
			
		}
		return false;
	}

	public static void main(String[] args) {
		ContinuousSubArraySum arraySum = new ContinuousSubArraySum();
		System.out.println(arraySum.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
		System.out.println(arraySum.checkSubarraySum(new int[] { 23, 2, 4, 6, 6 }, 7));
		System.out.println(arraySum.checkSubarraySum(new int[] { 1, 0 }, 2));
	}
}
