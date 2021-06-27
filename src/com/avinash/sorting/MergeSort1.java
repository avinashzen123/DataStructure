package com.avinash.sorting;

import java.util.Arrays;

public class MergeSort1 {
	private int[] array;

	public MergeSort1(int[] array) {
		super();
		this.array = array;
	}

	public static void main(String args[]) {
        int arr[] = {12, 4, 11, 13, 5, 6, 7};
        MergeSort1 mergeSort = new MergeSort1(arr);
        System.out.println(Arrays.toString(mergeSort.array));
        mergeSort.sort();
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(mergeSort.array));
    }


	public void sort() {
		this.sort(0, this.array.length - 1);
	}

	private void sort(int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			sort(start, middle);
			sort(middle + 1, end);
			this.merge(start, middle, end);
		}
	}

	private void merge(int start, int middle, int end) {
		int[] leftSubArray = Arrays.copyOfRange(this.array, start, middle + 1);
		int[] rightSubArray = Arrays.copyOfRange(this.array, middle + 1, end + 1);
		int i = 0, j = 0, k = start;
		while( i < leftSubArray.length && j < rightSubArray.length) {
			this.array[k++] = leftSubArray[i] < rightSubArray[j] ? leftSubArray[i++] : rightSubArray[j++];
		}
		copyRestOfArray(rightSubArray, j, copyRestOfArray(leftSubArray, i, k));
	}
	
	private int copyRestOfArray(int[] subArray, int i, int k) {
        while (i < subArray.length) {
            this.array[k++] = subArray[i++];
        }
        return k;
    }

}
