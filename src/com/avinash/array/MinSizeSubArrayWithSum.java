package com.avinash.array;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to
 * target. If there is no such subarray, return 0 instead.
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3] 
 * 
 * Output: 2 
 * Explanation: The subarray
 * [4,3] has the minimal length under the problem constraint.
 * 
 */
public class MinSizeSubArrayWithSum {
	public int minSubArrayLen_BruteForce(int target, int[] nums) {
		int n = nums.length;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += nums[k];
				}
				if (sum >= target) {
					ans = Math.min(ans, (j - i + 1));
				}
			}
		}
		return (ans != Integer.MAX_VALUE) ? ans : 0;
	}
	
	public int minSubArrayLenTwoPointer(int target, int[] nums) {
		int sum = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
	}
	
	public static void main(String[] args) {
		System.out.println(new MinSizeSubArrayWithSum().minSubArrayLen_BruteForce(7, new int[] {2,3,1,2,4,3}));
		System.out.println(new MinSizeSubArrayWithSum().minSubArrayLenTwoPointer(7, new int[] {2,3,1,2,4,3}));

	}
}
