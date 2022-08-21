package com.avinash.dynamic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestIncresingSubsequence {

	public static int longestIncresingSubseqence(int[] array) {
		int[] dp = new int[array.length];
		IntStream.range(0, array.length).forEach(i-> dp[i] =1 );
		for (int i = array.length-1; i>=0; i--) {
			for (int j = i; j < array.length; j++) {
				if (array[i] < array[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
		}
		return Arrays.stream(dp).max().getAsInt();
	}
	
	public static void main(String[] args) {
		System.out.println(longestIncresingSubseqence(new int[] {1,2,4,3}));
	}
}
