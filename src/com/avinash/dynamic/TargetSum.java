package com.avinash.dynamic;

import java.util.Arrays;

// https://leetcode.com/problems/target-sum/description/
public class TargetSum {

	// Time complexity : O(2^n)
	static class Recursion {
		int count = 0;
		public int findTargetSumWays(int[] nums, int s) {
			calculate(nums, 0, 0, s);
			return count;
		}
		private void calculate(int[] nums, int i, int sum, int target) {
			if (i == nums.length) {
				if (sum == target) {
					count++;
				}
			} else {
				calculate(nums, i + 1, sum + nums[i], target);
				calculate(nums, i + 1, sum - nums[i], target);
			}
		}
	}
	
	// Time complexity : O(t * n)
	static class RecursionWithMemoiazation {
		int total = 0;
		public int findTargetSumWays(int[] nums, int s) {
			total = Arrays.stream(nums).sum();
			int[][] memo = new int[nums.length][2 * total + 1];
			Arrays.stream(memo).forEach(row -> Arrays.fill(row, Integer.MIN_VALUE));
			int res = calculate(nums, 0, 0, s, memo);
			Arrays.stream(memo).map(Arrays::toString).forEach(System.out::println);
			return res;
		}
		
		private int calculate(int[] nums, int i, int sum, int target, int[][] memo) {
			if (i == nums.length) {
				if (sum == target) {
					return 1;
				} else {
					return 0;
				}
			} else {
				if(memo[i][sum + total] != Integer.MIN_VALUE) {
					return memo[i][sum + total];
				}
				int add = calculate(nums, i + 1, sum + nums[i], target, memo);
				int substract = calculate(nums, i + 1, sum - nums[i], target, memo);
				memo[i][sum + total] = add + substract;
				return memo[i][sum + total];
			}
		}
	}
	
	static class DPTab {
		public int findTargetSumWays(int[] nums, int S) {
			int total = Arrays.stream(nums).sum();
			int[][] dp = new int[nums.length][2* total + 1];
			dp[0][nums[0] + total] = 1;
			dp[0][-nums[0] + total] += 1;
			for (int i = 1; i < nums.length; i++) {
				for (int sum = -total; sum <= total; sum++) {
					if (dp[i - 1][sum + total] > 0) {
						dp[i][sum + nums[i] + total] += dp[i-1][sum + total];
						dp[i][sum - nums[i] + total] += dp[i-1][sum + total];
					}
				}
			}
			Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
			return Math.abs(S) > total ? 0 : dp[nums.length - 1] [S + total];
		}
	}
	
	static class OneDDP {
		public int findTargetSumWays(int[] nums, int S) {
			int total = Arrays.stream(nums).sum();
			int[] dp = new int[2 * total + 1];
			dp[nums[0] + total] = 1;
			dp[-nums[0] + total] += 1;
			for (int i = 1; i < nums.length; i++) {
				int[] next = new int[2 * total + 1];
				for (int sum = -total ; sum <= total; sum++) {
					if (dp[sum + total] > 0) {
						next[sum + nums[i] + total] += dp[sum + total];
						next[sum - nums[i] + total] += dp[sum + total];
					}
				}
				dp = next;
			}
			return Math.abs(S) > total ? 0 : dp[S + total];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 1 };
		System.out.println(new RecursionWithMemoiazation().findTargetSumWays(arr, 3));
	}
}
