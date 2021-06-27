package com.avinash.interview;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-number-of-swaps-required-to-sort-an-array-of-first-n-number/
public class CountNumberOfSwapsInSorting {
	public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 1, 5 };
        
        // Function to find minimum swaps
        System.out.println(minimumSwaps(arr));
        System.out.println(Arrays.toString(arr));
	}

	static int minimumSwaps(int[] arr) {
		// Initialise count variable
		int count = 0;
		int i = 0;
		while (i < arr.length) {

			// If current element is
			// not at the right position
			if (arr[i] != i + 1) {

				while (arr[i] != i + 1) {
					int temp = 0;

					// Swap current element
					// with correct position
					// of that element
					temp = arr[arr[i] - 1];
					arr[arr[i] - 1] = arr[i];
					arr[i] = temp;
					count++;
				}
			}

			// Increment for next index
			// when current element is at
			// correct position
			i++;
		}
		return count;
	}
}
