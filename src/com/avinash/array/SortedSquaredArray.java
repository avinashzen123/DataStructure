package com.avinash.array;

import java.util.Arrays;

public class SortedSquaredArray {
	public static int[] sortedSquaredArray(int[] array) {
		// Write your code here.
		int length = array.length - 1;
		int[] result = new int[array.length];
		int start = 0;
		int end = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			if (Math.abs(array[start]) > Math.abs(array[end])) {
				result[length - i] = array[start] * array[start++];
			} else {
				result[length - i] = array[end] * array[end--];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] sortedSquaredArray = sortedSquaredArray(new int[] {0, 25, 25, 100, 100});
		System.out.println(Arrays.toString(sortedSquaredArray));
	}
}
