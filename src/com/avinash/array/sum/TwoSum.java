package com.avinash.array.sum;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/
/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order
 * 
 * Input: nums = [2,7,11,15], target = 9
 * 
 * Output: [0,1]
 * 
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 */
public class TwoSum {
	static class BruteForce {
		static int[] twoSum(int[] nums, int target) {
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] + nums[j] == target) {
						return new int[] { i, j };
					}
				}
			}
			return null;
		}
	}

	static class TwoPassHashTable {
		static int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				map.put(nums[i], i);
			}
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (map.containsKey(complement) && map.get(complement) != i) {
					return new int[] { i, map.get(complement) };
				}
			}
			return null;
		}
	}

	static class OnePassHashTable {
		static int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (map.containsKey(complement)) {
					return new int[] { map.get(complement), i };
				}
				map.put(nums[i], i);
			}
			return null;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		System.out.println(OnePassHashTable.twoSum(nums, 9));
	}
}
