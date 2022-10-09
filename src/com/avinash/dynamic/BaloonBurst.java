package com.avinash.dynamic;

public class BaloonBurst {

	public static int maxCoinsDp(int[] nums) {
		int n = nums.length;
		int arr[] = new int[n + 2];
		arr[0] = arr[n + 1] = 1; // Giving padding of 1 to the corner elements
		for (int i = 1; i <= n; i++) {
			arr[i] = nums[i - 1]; // final padded array
		}

		int dp[][] = new int[n + 2][n + 2];

		for (int window = 1; window <= n; window++) { // window size

			for (int left = 1; left <= n - window + 1; left++) { // left pointer

				int right = left + window - 1; // right pointer

				for (int i = left; i <= right; i++) { // iterate from left to right

					dp[left][right] = Math.max(dp[left][right],
							(arr[left - 1] * arr[i] * arr[right + 1]) + dp[left][i - 1] + dp[i + 1][right]);

				}
			}
		}
//		Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
		return dp[1][n];
	}

	public static int maxCoinsMemoization(int[] nums) {
		int[] array = new int[nums.length + 2];
		array[0] = 1;
		for (int i = 0; i < nums.length; i++) {
			array[i + 1] = nums[i];
		}
		array[array.length - 1] = 1;
		int[][] table = new int[nums.length + 2][nums.length + 2];
		return dfs(table, array, 1, array.length - 2);
	}

	private static int dfs(int[][] table, int[] nums, int left, int right) {
		if (left > right)
			return 0;
		if (table[left][right] != 0)
			return table[left][right];
		table[left][right] = 0;
		for (int i = left; i < right; i++) {
			int coins = nums[i - 1] * nums[i] * nums[i + 1];
			coins += dfs(table, nums, left, i - 1) + dfs(table, nums, i + 1, right);
			table[left][right] = Math.max(table[left][right], coins);
		}
		return table[left][right];
	}

	public static void main(String[] args) {
		System.out.println(maxCoinsMemoization(new int[] { 3, 1, 5, 8 }));
		
		int[] nums = { 3, 1, 5, 8 };
		System.out.println(maxCoinsDp(nums));
		System.err.println(maxCoinsDp(new int[] {1, 5}));
	}
}
