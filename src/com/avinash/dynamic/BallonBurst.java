package com.avinash.dynamic;

import java.util.Arrays;

// https://www.youtube.com/watch?v=VFskby7lUbw
public class BallonBurst {

	static int maxCoins(int[] nums) {
		int n = nums.length + 2;
		int[] newNums = new int[n];
		System.arraycopy(nums, 0, newNums, 1, n - 2);
		newNums[0] = 1;
		newNums[n - 1] = 1;
		System.out.println(Arrays.toString(newNums));
		// dp[i][j] represents
		// maximum if we burst all nums[left]...nums[right], inclusive
		int[][] dp = new int[n][n];

		// do not include the first one and the last one
		// since they are both fake balloons added by ourselves and we can not burst
		// them
//		for (int left = n - 2; left > 0; left--) {
//			for (int right = left; right <= n - 2; right++) {
//				// find the last burst one in newNums[left]...newNums[right]
////				for (int i = left; i <= right; i++) {
//				for (int i = right; i >= left; i--) {
//					// newNums[i] is the last burst one
//					int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
//					// recursively call left side and right side
//					int remaining = dp[left][i - 1] + dp[i + 1][right];
//					dp[left][right] = Math.max(remaining + gain, dp[left][right]);
//				}
//			}
//		}
		for (int left = nums.length ; left > 0; left--) {
            for (int right = left; right <= nums.length; right ++) {
                for (int i = right; i >= left; i--) {
                	System.out.println("left " + left + " i " + i + " right " + right);
                    int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
                    int remaining = dp[left][i - 1] + dp[i + 1][right];
                    dp[left][right] = Math.max(gain + remaining , dp[left][right]);
                } 
            }
        }
		
//		Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
		return dp[1][n - 2];
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 5, 8 };
		System.out.println(maxCoins(nums));
		System.out.println(maxCoins(new int[] { 1, 5 }));
	}
}
