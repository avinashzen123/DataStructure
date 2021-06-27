package com.avinash.interview;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/
 * 
 * Input: nums = [1,2,3,4,5,6,7], 
 * k = 3 
 * Output: [5,6,7,1,2,3,4] 
 * Explanation:
 * 
 * rotate 1 steps to the right: [7,1,2,3,4,5,6] 
 * rotate 2 steps to the right: [6,7,1,2,3,4,5] 
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class Rotate1DArray {
	private static void swap (int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static void reverse(int[] arr, int left, int right) {
		while(left < right) {
			swap(arr, left++, right--);
		}
	}
	public static void rotateArray(int[] array, int k) {
		if (array == null || array.length == 1) {
			return;
		}
		reverse(array, 0, array.length - k - 1);
		reverse(array, array.length - k, array.length -1);
		reverse(array, 0, array.length -1);
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		rotateArray(array, 3);
		System.out.println(Arrays.toString(array));
	}
}
