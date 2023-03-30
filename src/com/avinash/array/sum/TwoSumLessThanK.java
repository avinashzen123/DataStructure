package com.avinash.array.sum;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-less-than-k/description/
/**
 * Given an array nums of integers and integer k, return the maximum sum such
 * that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j
 * exist satisfying this equation, return -1.
 * 
 * Input: nums = [34,23,1,24,75,33,54,8], k = 60
 * 
 * Output: 58
 * 
 * Explanation: We can use 34 and 24 to sum 58 which is less than 60.
 *
 * 
 * Input: nums = [10,20,30], k = 15
 * 
 * Output: -1
 * 
 * Explanation: In this case it is not possible to get a pair sum less that 15.
 * 
 */
public class TwoSumLessThanK {
	static class BruteForce {
		static int twoSumLessThanK(int[] nums, int k) {
			int answer = -1;
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					int sum = nums[i] + nums[j];
					if (sum < k) {
						answer = Math.max(answer, sum);
					}
				}
			}
			return answer;
		}
	}

	static class TwoPointer {
		static int twoSumLessThanK (int[] nums, int k) {
			Arrays.sort(nums);
			int answer = -1;
			int left = 0;
			int right = nums.length - 1;
			while(left < right) {
				int sum = nums[left] + nums[right];
				if (sum < k) {
					answer = Math.max(answer, sum);
					left ++;
				} else {
					right --;
				}
			}
			return answer;
		}
	}
	
	static class BinarySearch {
		static int twoSumLessThanK(int[] nums, int k) {
			int answer = -1;
			Arrays.sort(nums);
			for (int i = 0; i < nums.length; i++) {
				int idx = Arrays.binarySearch(nums, i + 1, nums.length, k - nums[i] - 1);
				int j = (idx >= 0 ? idx : ~idx);
				if (j == nums.length || nums[j] > k - nums[i] - 1) {
					j --;
				}
				if (j > i) {
					answer = Math.max(answer, nums[i] + nums[j]);
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 34, 23, 1, 24, 75, 33, 54, 8 };
		System.out.println(BinarySearch.twoSumLessThanK(nums, 60));
	}
}
