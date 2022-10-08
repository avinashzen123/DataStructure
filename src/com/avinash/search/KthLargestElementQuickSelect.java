package com.avinash.search;

public class KthLargestElementQuickSelect {

	public static int kthLargestElement(int[] array, int k) {
		k = array.length - k;
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int pivot = partition(array, left, right);
			if (pivot < k) {
				left = pivot + 1;
			} else if (pivot > k) {
				right = pivot - 1;
			} else {
				break;
			}
		}
		return array[k];
	}

	private static int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int fill = left;
		for (int i = left; i < right; i++) {
			if (array[i] <= pivot) {
				swap(array, fill++, i);
			}
		}
		swap(array, fill, right);
		return fill;
	}

	private static void swap(int[] array, int fill, int i) {
		int temp = array[i];
		array[i] = array[fill];
		array[fill++]= temp;
	}
	
	public static void main(String[] args) {
		System.out.println(kthLargestElement(new int[] {1, -5, 10, 55, 2, 3, -7, 7, 11}, 6));
	}
}
