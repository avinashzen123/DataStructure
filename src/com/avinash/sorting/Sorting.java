package com.avinash.sorting;

import java.util.Arrays;

// Tim Sort and Intra Sort
public class Sorting {
	public static void bubbleSort(int[] array) {
		boolean toSwap = true;
		while (toSwap) {
			toSwap = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					toSwap = true;
				}
			}
		}
	}

	// https://www.geeksforgeeks.org/insertion-sort/
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			for (; j >= 0 && arr[j] > key; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = key;
		}
	}
	// Time complexity O(n^2)
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// Find the minimum element in sorted array
			int min_index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min_index]) min_index = j;
			}
			swap(arr, i, min_index);
		}
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 22, 11, 34, 12, 21, 8 };
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		array = new int[] { 22, 11, 34, 12, 21, 8 };
		insertionSort(array);
		System.out.println(Arrays.toString(array));
		array = new int[] { 22, 11, 34, 12, 21, 8 };
		selectionSort(array);
		System.out.println(Arrays.toString(array));
	}
}
