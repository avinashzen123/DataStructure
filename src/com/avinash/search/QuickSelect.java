package com.avinash.search;

import java.util.Random;

public class QuickSelect {
	
	public static int select(int[] array, int k) {
		return quickSelect(array, 0, array.length - 1, k - 1);
	}

	private static int quickSelect(int[] array, int firstIndex, int lastIndex, int k) {
		int pivotIndex = partition(array, firstIndex, lastIndex);
		if (pivotIndex < k) {
			//We have to discard left sub-array so we have to consider items on right 
			return quickSelect(array, pivotIndex + 1, lastIndex, k);
		} else if (pivotIndex > k ) {
			//We have to discard the right sub-array so we have to consider left subarray
			return quickSelect(array, firstIndex, pivotIndex - 1, k);
		} else {
			return array[pivotIndex];			
		}
	}

	/**
	 *  {1, -5, 10, 55, 2, 3, -7, 7, 11}
	 *  firstIndex = 0
	 *  lastIndex = 8
	 *  pivot = 5
	 *  {1, -5, 10, 55, 2, 11, -7, 7, 3}
	 *  
	 *  
	 * @param array
	 * @param firstIndex
	 * @param lastIndex
	 * @return
	 */
	private static int partition(int[] array, int firstIndex, int lastIndex) {
		int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;
		swap(array, pivot, lastIndex);
		for (int i = firstIndex; i < lastIndex; i++) {
			if (array[i] < array[lastIndex]) {
				swap(array, i, firstIndex);
				firstIndex++;
			}
		}
		swap(array, lastIndex, firstIndex);
		return firstIndex;
	}

	private static void swap(int[] array, int pivot, int lastIndex) {
		int temp = array[pivot];
		array[pivot] = array[lastIndex];
		array[lastIndex] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {1, -5, 10, 55, 2, 3, -7, 7, 11};
		System.out.println(select(nums, 6));
	}
}
