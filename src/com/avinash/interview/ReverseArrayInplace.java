package com.avinash.interview;

import java.util.Arrays;

public class ReverseArrayInplace {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5};
		reverse(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void reverse(int[] array) {
		int start = 0;
		int end = array.length - 1;
		
		while(start < end) {
			swap(array, start++, end--);
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
