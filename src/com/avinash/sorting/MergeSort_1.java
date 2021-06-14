package com.avinash.sorting;

import java.util.Arrays;

public class MergeSort_1 {
	private final int[] array;

	public MergeSort_1(int[] array) {
		super();
		this.array = array;
	}

	public void sort() {
		this.sort(0, this.array.length - 1);
	}

	private void sort(int low, int high) {
		if (low < high) {
			int middle = (low + high)/2;
			this.sort(low, middle);
			this.sort(middle + 1, low);
			this.merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		int[] leftSubArray = Arrays.copyOfRange(this.array, low, low + (middle - low) + 1);
		int[] rightSubArray = Arrays.copyOfRange(this.array, middle + 1, middle + (high - middle) + 1);
		int leftIndex = 0, rightIndex = 0, parentIndex = low;
		while(leftIndex < leftSubArray.length && rightIndex < rightSubArray.length) {
			this.array[parentIndex ++] = leftSubArray[leftIndex] < rightSubArray[rightIndex] ? leftSubArray[leftIndex ++] : rightSubArray[rightIndex ++];
		}
		while(leftIndex < leftSubArray.length) {
			this.array[parentIndex++] = leftSubArray[leftIndex++];
		}
		while(rightIndex < rightSubArray.length) {
			this.array[parentIndex++] = rightSubArray[rightIndex++];
		}
	}
	
	
	
	public static void main(String args[]) {
		int arr[] = { 12, 4, 11, 13, 5, 6, 7 };
		MergeSort_1 ob = new MergeSort_1(arr);
		System.out.println("Given Array");
		System.out.println(Arrays.toString(ob.array));
		ob.sort();
		System.out.println("\nSorted array");
		System.out.println(Arrays.toString(ob.array));
	}
}
