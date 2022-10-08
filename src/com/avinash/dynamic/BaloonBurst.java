package com.avinash.dynamic;

public class BaloonBurst {

	public static int maxCoins(int[] nums) {
		int[] array = new int[nums.length + 2];
		array[0] = 1;
		for (int i = 0; i < nums.length; i++) {
			array[i+1] = nums[i];
		}
		array[array.length-1] = 1;
		int[][] table = new int[nums.length + 2][nums.length + 2];
		return dfs(table, array, 1, array.length - 2);
	}
	
	
	private static int dfs(int[][] table, int[] nums, int left, int right) {
		if (left > right) return 0;
		if (table[left][right] != 0) return table[left][right];
		table[left][right] = 0;
		for (int i = left; i < right; i++) {
			int coins = nums[i-1] * nums[i] * nums[i+1];
			coins += dfs(table, nums, left, i - 1) + dfs(table, nums, i+1, right);
			table[left][right] = Math.max(table[left][right], coins);
		}
		return table[left][right];
	}
	
	public static void main(String[] args) {
		System.out.println(maxCoins(new int[] {3, 1, 5, 8}));
	}
}
