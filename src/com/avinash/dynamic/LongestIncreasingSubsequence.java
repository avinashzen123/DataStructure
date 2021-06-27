package com.avinash.dynamic;

import java.util.stream.IntStream;

public class LongestIncreasingSubsequence {

	public static int longestIncreasingSubsequence(int[] arr, int pos, int prevValue) {
		if (pos == arr.length) {
			return 0;
		}
		int result = 0;
		if (arr[pos] > prevValue) {
			result = 1 + longestIncreasingSubsequence(arr, pos + 1 , arr[pos]);
		}
		int result2 = longestIncreasingSubsequence(arr, pos + 1, prevValue);
		return Math.max(result, result2);
	}
	
	public static int longestIncreasingSubsequence(int[] arr) {
		return IntStream.range(0, arr.length - 1)
			.map(i -> longestIncreasingSubsequence(arr, i + 1, arr[i]))
			.max().getAsInt() + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(longestIncreasingSubsequence(new int[] {2, 5, 8, 3, 4, 6}));
	}
}
