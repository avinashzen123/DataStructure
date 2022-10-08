package com.avinash.dynamic;

// https://www.youtube.com/watch?v=VFskby7lUbw
public class BallonBurst {

	public static int burstCoins(int[] nums) {
		int maxCoin = 1;

		int[][] dp = new int[nums.length][nums.length];
		return burstCoin(nums, 0, nums.length - 1, dp);
	}

	private static int burstCoin(int[] baloonMoney, int start, int end, int[][] dp) {
		if (start > end)
			return 0;
		int prev = start > 0 ? baloonMoney[start - 1] : 1;
		int next = end > baloonMoney.length - 1 ? 1 : baloonMoney[end];
		if (start == end)
			return prev * baloonMoney[start] * next;

		if (dp[start][end] == 0) {
			dp[start][end] = Integer.MIN_VALUE;
			for (int i = start; i <= end; i++) {
				int curr = prev * baloonMoney[i] * next + burstCoin(baloonMoney, start, i - 1, dp)
						+ burstCoin(baloonMoney, i + 1, end, dp);
				dp[start][end] = Math.max(dp[start][end], curr);
			}
		}

		return dp[start][end];
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 5, 8 };
		System.out.println(burstCoins(nums));
	}
}
