package com.avinash.array;

import java.util.Arrays;

public class MaxIncresingSubsequence {

	public static int[] maxSumIncreasingSubSequence(int[] array) {
		int[] subSesequence = new int[array.length];
		Arrays.fill(subSesequence, -1);
		int[] sum = Arrays.copyOf(array, array.length);
		int maxSumIdx = 0;
		for (int i = 1; i < array.length; i++) {
			int currentNum = array[i];
			for (int j = 0; j < i; j++) {
				int otherSum = array[j];
				if (otherSum < currentNum && sum[j] + currentNum >= sum[i]) {
					sum[i] = sum[j] + currentNum;
					subSesequence[i] = j;
				}
			}
			if (sum[maxSumIdx] <= sum[i]) {
				maxSumIdx = i;
			}
		}
		int result[] = new int[maxSumIdx];
		for (int i = maxSumIdx - 1; i >= 0; i--) {
			if (maxSumIdx != -1) {
				result[i] = array[maxSumIdx];
				maxSumIdx = subSesequence[maxSumIdx];
			}
		}
		System.out.println(Arrays.toString(result));
		return null;
	}

	public static void main(String[] args) {
		maxSumIncreasingSubSequence(new int[] { 10, 70, 20, 30, 50, 15 });
	}
}
