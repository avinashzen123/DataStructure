package com.avinash.dynamic;

import java.util.Arrays;
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
	
	public static int lengthOfLIS(int[] nums) {
        //O(n^2)
        if (nums.length == 1) return 1;

        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        int maximumSoFar = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(1 + LIS[j], LIS[i]);
                }
            }
            maximumSoFar = Math.max(maximumSoFar, LIS[i]);
        }
        return maximumSoFar;
    }

	
	public static void main(String[] args) {
		System.out.println(longestIncreasingSubsequence(new int[] {2, 5, 8, 3, 4, 6}));
		System.out.println(lengthOfLIS(new int[] {2, 5, 8, 3, 4, 6}));

	}
}
