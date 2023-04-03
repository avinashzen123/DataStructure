package com.avinash.dynamic;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-height-by-stacking-cuboids/description/
public class MaxHeightByStackingDisk {
	public int maxHeight(int[][] cuboids) {
		Arrays.stream(cuboids).forEach(o -> Arrays.sort(o));
		Arrays.stream(cuboids).map(Arrays::toString).forEach(System.out::println);
		Arrays.sort(cuboids, (a, b) -> {
			if(a[0] != b[0]) return a[0] - b[0];
			if(a[1] != b[1]) return a[1] - b[1];
			return a[2] - b[2];
		});
		System.out.println("--------------");
		Arrays.stream(cuboids).map(Arrays::toString).forEach(System.out::println);
		int ans = 0;
		int[] dp = new int[cuboids.length];
		for (int i = 0; i < cuboids.length; i++) {
			dp[i] = cuboids[i][2];
//			System.out.println(cuboids[i][2]);
			for (int j = 0; j < i; j++) {
				if (cuboids[i][0] >= cuboids[j][0] 
						&& cuboids[i][1] >= cuboids[j][1]
								&& cuboids[i][2] >= cuboids[j][2]) {
					dp[i] = Math.max(dp[i], cuboids[i][2] + dp[j]);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] cuboids = { { 50, 45, 20 }, { 95, 37, 53 }, { 45, 23, 12 } };
		int maxHeight = new MaxHeightByStackingDisk().maxHeight(cuboids);
		System.out.println("Max Height " + maxHeight);
		
		cuboids = new int[][] {{7,11,17},{7,17,11},{11,7,17},{11,17,7},{17,7,11},{17,11,7}};
		System.out.println(new MaxHeightByStackingDisk().maxHeight(cuboids));
	}
}
